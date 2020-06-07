package jtm.activity10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Reader;

/*-
 * This is simple text stream editor. It reads text from file/standard input,
 * changes/deletes passed line and writes everything into file/standard output.
 *
 * Parameters:
 *
 * 1. number of line.
 *    If positive number, line is replaced/added into text,
 *    if negative, line is deleted from the text.
 * 2. Text to add/replace into specified line.
 *    If number is negative, enter dash (or whatever) as a padding
 *    for this parameter as it will be ignored.
 * 3. input file.
 *    If dash is specified, editor reads from standard input, otherwise it is file name.
 * 4. output file.
 *    If dash is specified, editor writes to standard input, otherwise it is file name.
 * HINTS:
 * 1. to pass parameters, you can run editor in terminal, for example, with following command:
 *   java -cp target/classes jtm.activity10.StreamEditor 2 aaaa - -
 * 2. to pass parameters for command in Eclipse, select:
 *   a) menu: Run — Run configurations...
 *   b) tree: Java applications — StreamEditor
 *   c) tab arguments, and field Program arguments, enter parameters there
 *   d) press Run
 */
public class StreamEditor {

	public static void main(String[] args) throws Exception {
		String inFileName, outFileName; // Names of input and output files
		int inLineNo = 0; // Line number, which needs to be changed, deleted
		String content; // String content which needs to be put in line
		PrintWriter writer = null; // Buffered writer of characters
		BufferedReader reader = null; // Buffered reader of characters
		File inFile; // File for file system operations
		int curLineNo = 0; // Counter of current/read line of input file
		String curLineContent; // Content of current line of input file
		boolean delete = false; // Should delete line?

		/*-  Check number of passed parameters. If they are null or number of
		 * them is not 4, write to standard error (System.err):
		 * Please use arguments: [-]lineNo (TextToAdd/Replace|-) (inputFile|-) (outputFile|-)
		 * and exit with System.exit(1); to pass error status of finished program.
		 */
		if ((args.length == 0) || (args.length != 4)) {
			System.err.println("Please use arguments: [-]lineNo (TextToAdd/Replace|-) (inputFile|-) (outputFile|-)");
			System.exit(1);
		}

		// Get integer from the 1st argument. Note that line should be
		// deleted if number is negative.
		// Hint. Use Integer.parseInt() to parse String into integer
		if (Integer.parseInt(args[0]) > 0) {
			inLineNo = Integer.parseInt(args[0]);
		}else {
			delete = true;
		}

		// set value of the string from 1st parameter into content
		content = args[0];


		/*-  Initialize new buffered character reader (BufferedReader) and:
		 * 1. If input file name (3rd parameter) is "-", s (System.in).
		 * 2. Otherwise check if file exists (if it doesn't, create it) and
		 *    add reader to this file.
		 */
		if (args[2] == "-") {
			reader = new BufferedReader(new InputStreamReader(System.in));
		} else {
			inFileName = args[2];
			inFile = new File(inFileName);
			if (inFile.exists()) {
			} else {
				inFile.createNewFile();
			}
			reader = new BufferedReader(new FileReader(inFile));
		}

		/*-  Initialize new buffered character writer (PrintWriter) and:
		 *  1. If output file name (4th parameter) is "-", add writer to the standard output (System.out)
		 *  2. Otherwise initialize writer to the file of given name.
		 */
		if (args[3] == "-") {
			writer = new PrintWriter(System.out);
		} else {
			outFileName = args[3];
			writer = new PrintWriter(new PrintStream(outFileName));
		}

		//  Read lines in loop from passed file/standard input till to the
		// end. Count number of read lines. Before appending line into writer
		// check, if it needs to be changed/deleted. Change its value to passed
		// content or just skip appending it to the writer.
		// NOTE: append break at the end of written line only if it is NOT null
		// or empty string!


		while ((curLineContent = reader.readLine()) != null) {
			if(curLineNo > 0) {
				writer.write(System.getProperty("line.separator"));
			}
			curLineNo++;
			if(inLineNo > 0) {
				delete = false;
				content = curLineContent;
			}else {
				delete = true;
				content = "";
			}
			writer.write(content);
		}

		// TODO If number of input line is larger than number of lines in file,
		// pad file with empty lines before necessary line.



		//  flush cache of the writer and close connections of the reader
		// and writer

		writer.flush();
		reader.close();
		writer.close();
	}

	private static Reader readLine(InputStream in) {
		// TODO Auto-generated method stub
		return null;
	}
}