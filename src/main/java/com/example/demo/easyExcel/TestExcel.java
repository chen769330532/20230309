package com.example.demo.easyExcel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;

public class TestExcel {

	public static void main(String[] args) throws Exception {

		String path = "D:/easyExcel";
		File file = new File(path);
		if(!file.exists()) {
			file.mkdir();
		}

		Date date = new Date();
		String datePath = new SimpleDateFormat("yyyy-MM-dd").format(date);

		OutputStream out = new FileOutputStream(path+"/"+datePath+".xlsx");
		ExcelWriter writer = EasyExcelFactory.getWriter(out);

		Sheet sheet = new Sheet(1, 0, WriteModel.class);
		sheet.setSheetName("我的第一个excel导出");
		writer.write(sheetList(), sheet);
		writer.finish();
		out.close();
	}

	private static List<WriteModel> sheetList() {
		List<WriteModel> writeModels = new ArrayList<WriteModel>();
		for (int i = 0; i < 100; i++) {
			WriteModel writeModel = new WriteModel();
			writeModel.setName("俊良"+i);
			writeModel.setPassword("abc"+i);
			writeModel.setAge("年龄:"+i);
			writeModels.add(writeModel);
		}
		return writeModels;
	}
}
