@echo off
set logfile=overtureInstall.log

if (%1) == () goto PRINTMENU
goto TESTMVN
:TESTCHOICE
echo Maven found
if (%1) == (install) goto INSTALL
if (%1) == (clean) goto CLEAN

goto END

:TESTMVN
echo Looking for Maven in path...
call mvn -v > %logfile%
if "%ERRORLEVEL%" == "0" goto TESTCHOICE

echo Maven not found
exit /B 1


:INSTALL
echo install

TITLE Making Overture - Core

echo Making overture


echo making core

cd core
call mvn install -Dmaven.test.skip=true > %logfile%
if "%ERRORLEVEL%" == "0" goto INSTALL1
echo Could not install core components
type %logfile%
exit /B 1
:INSTALL1
cd..

TITLE Making Overture - Eclipse Projects
echo Making Eclipse:eclipse

call mvn eclipse:eclipse > %logfile%
if "%ERRORLEVEL%" == "0" goto INSTALL2
echo Could not create eclipse projects. Do not attempt to import before eclipse:eclipse has been executed. (If not there will be failures in the eclipse projects so dependencies will be imposible to resolv
echo
type %logfile%
exit /B 1
:INSTALL2
TITLE Making Overture - Updating Generated plugins
echo Updating generated core components for the IDE

cd ide\generated
call mvn psteclipse:eclipse-plugin > %logfile%
if "%ERRORLEVEL%" == "0" goto INSTALL3
echo The core components could not be wrapped into eclipse plugins. The Editor will not be able to compile but the core components are avaliable
type %logfile%
exit /B 1
:INSTALL3
cd..
cd..

TITLE Making Overture - Ready for Eclise import as Maven Projects
echo Now you can import (Maven Projects) the IDE module in eclipse and develop new stuff here. Remember to update classpath on the manifest in org.overture.ide.generated.* packages

goto END



:CLEAN
echo clean
TITLE Clean Overture - Core

echo Making overutre


echo clean core

cd core
call mvn clean -o > %logfile%
if "%ERRORLEVEL%" == "0" goto CLEAN1
echo Could not clean core
type %logfile%
exit /B 1
:CLEAN1
cd..

TITLE Clean Overture - Eclipse Projects
echo Making Eclipse:clean

call mvn eclipse:eclean -o > %logfile%
if "%ERRORLEVEL%" == "0" goto CLEAN2
echo Could not clean all eclipse related files
type %logfile%
exit /B 1
:CLEAN2
goto END


:PRINTMENU

echo Overture development setup
echo 	Install: Prepare all sources for development
echo 	Clean  : Clean all autogenerated source



:END
