/**
 * 
 */
package org.overturetool.potrans.preparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.List;

/**
 * @author miguel_ferreira
 * 
 */
public class CommandLineProcess {

	protected ProcessBuilder processBuilder = null;
	protected Process process = null;

	/**
	 * Constructs a command line process with errors redirected to standard output.
	 * @throws IOException
	 * @throws InterruptedException
	 * 
	 */
	public CommandLineProcess(CommandLineProcessCommand command) throws IOException {
		processBuilder = new ProcessBuilder(command.getCommandArray());
		processBuilder.redirectErrorStream(true);
	}

	/**
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public int executeProcessAndWaitForItToFinish() throws IOException, InterruptedException {
		process = processBuilder.start();
		return process.waitFor();
	}
	
	/**
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void executeProcess() throws IOException {
		process = processBuilder.start();
	}

	/**
	 * Gets the output from the process. Until the process finishes the output will always be empty. 
	 * @return the output text by the process.
	 * @throws IOException
	 */
	public String getProcessOutput() throws IOException {
		return getProcessOutputFromStream(process.getInputStream());
	}
	
	/**
	 * Returns the same as <code>getProcessOutput()</code> because
	 * errors are being redirected to standard output.
	 * @return
	 * @throws IOException
	 */
	public String getProcessError() throws IOException {
		return getProcessOutputFromStream(process.getInputStream());
	}

	public void setProcessInput(String input) throws IOException {
		OutputStream outputStream = process.getOutputStream();
		outputStream.write(input.getBytes());
		outputStream.flush();
	}
	
	public void setProcessInput(List<CommandLineProcessInput> inputs) throws IOException {
		OutputStream outputStream = process.getOutputStream();
		loopThroughInputs(inputs, outputStream);
	}

	/**
	 * @param inputs
	 * @param outputStream
	 * @throws IOException
	 */
	private void loopThroughInputs(List<CommandLineProcessInput> inputs,
			OutputStream outputStream) throws IOException {
		for(CommandLineProcessInput input : inputs)
			pipeInputToProcess(outputStream, input);
	}

	/**
	 * @param outputStream
	 * @param input
	 * @throws IOException
	 */
	private void pipeInputToProcess(OutputStream outputStream,
			CommandLineProcessInput input) throws IOException {
		if(input.isStatic())
			pipeStaticInputToProcess(outputStream, input);
		else
			pipeDynamicInputToProcess(outputStream, input);
		
		outputStream.flush();
	}

	/**
	 * @param outputStream
	 * @param input
	 * @throws IOException
	 */
	private void pipeStaticInputToProcess(OutputStream outputStream,
			CommandLineProcessInput input) throws IOException {
		outputStream.write(input.getBytes());
		outputStream.write((int)'\r');
	}

	/**
	 * @param outputStream
	 * @param input
	 * @throws IOException
	 */
	private void pipeDynamicInputToProcess(OutputStream outputStream,
			CommandLineProcessInput input) throws IOException {
		byte[] bytes = input.getBytes();
		while(bytes != null) {
			outputStream.write(bytes);
			bytes = input.getBytes();
		}
	}
	
	/**
	 * @param data
	 * @param dataStrem
	 * @throws IOException
	 */
	protected static String getProcessOutputFromStream(InputStream dataStrem)
			throws IOException {
		String result = "";

		if (dataStrem != null) {
			StringBuffer text = new StringBuffer();
			getTextFromStreamToStringBuffer(dataStrem, text);
			result = text.toString();
		}

		return result;
	}

	/**
	 * @param dataStrem
	 * @param textBufer
	 * @throws IOException
	 */
	protected static void getTextFromStreamToStringBuffer(InputStream dataStrem,
			StringBuffer textBufer) throws IOException {
		if (dataStrem != null && textBufer != null) {
			byte[] buffer = new byte[128];
			while (dataStrem.available() > 0) {
				int dataSize = dataStrem.read(buffer);
				textBufer.append(new String(buffer, 0, dataSize));
			}
		}
	}

	/**
	 * @return the exitValue
	 */
	public int getExitValue() {
		return process.exitValue();
	}
	
	public int waitFor() throws InterruptedException {
		return process.waitFor();
	}
	
	public void destroy() {
		process.destroy();
	}
	
	public boolean isFinished() {
		boolean finished = true;
		
		try {
			process.exitValue();
		} catch(IllegalThreadStateException e) {
			finished = false;
		}
		
		return finished;
	}

}
