package txt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import data.Data;

public class Txt {
	String path;
	public Txt(String path) {
		this.path=path;
	}
	
	public void writeContentToTxt(Data data, boolean onlyNumbers) throws IOException {

		if (path.equals(null)) {
			path = "defaultData.data";
		} else {
			path = path.replace(".xls", ".data");
		}
		BufferedWriter out = new BufferedWriter(new FileWriter(path));
		int totalRowNumber = data.getData().size();
		for (int row = 1; row < totalRowNumber; row++) {
			try {
				if (onlyNumbers) {
					writeNumbersRow(row, data, out);
				} else {
					writeRow(row, data, out);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		out.close();
	}

	public void writeToTxt(Data data, boolean onlyNumbers) throws IOException {

		if (path.equals(null)) {
			path = "defaultData.data";
		} else {
			path = path.replace(".xls", ".data");
		}
		BufferedWriter out = new BufferedWriter(new FileWriter(path));
		int totalRowNumber = data.getData().size();
		for (int row = 0; row < totalRowNumber; row++) {
			try {
				if (onlyNumbers) {
					writeNumbersRow(row, data, out);
				} else {
					writeRow(row, data, out);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		out.close();
	}

	private void writeNumbersRow(int row, Data data, BufferedWriter out) throws IOException {

		StringBuilder stringBuilder = new StringBuilder();

		Integer rowSize = Integer.valueOf(data.getData().get(row).size());
		for (int col = 0; col < rowSize - 1; col++) {
			try {
				Double.parseDouble(data.getData().get(row).get(col).toString());

				stringBuilder.append(data.getData().get(row).get(col).toString());
				stringBuilder.append(",");

			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			}
		}
		out.write(stringBuilder.toString() + "\n");
	}

	private void writeRow(int row, Data data, BufferedWriter out) throws IOException {

		StringBuilder stringBuilder = new StringBuilder();
		

		Integer rowSize = Integer.valueOf(data.getData().get(row).size());
		for (int col = 0; col < rowSize - 1; col++) {

			stringBuilder.append(data.getData().get(row).get(col).toString());
			stringBuilder.append(",");
			
		}
		out.write(stringBuilder.toString() + "\n");
	}

	public void loadData(Data data) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(path));
		String auxLine= null;
		String[] split = null;
		ArrayList<String> line;
		
		while((auxLine = in.readLine()) != null)
		{
			line = new ArrayList<String>();
			split = auxLine.split("/t");
			int splitLenght= split.length;
			for(int i=0;i<splitLenght;i++){
				line.add(split[i]);
			}
		    data.getData().add(line);
		    line.clear();
		}
		in.close();
	}
}
