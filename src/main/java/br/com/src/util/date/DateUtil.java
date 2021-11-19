package br.com.src.util.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String convertSecondsToHourNotation(Long time) {
		if (time == null) {
			time = 0l;
		}
		
		boolean isNegative = time < 0;
		if (isNegative) {
			time = -time;
		}
		
		int hours = (int)(time / 3600);
		int minutes = (int)((time % 3600) / 60);
		//int seconds = (int) (time % 60);

		String str = String.format("%02d:%02d", hours, minutes);
		return (isNegative)?("-"+str):str;		
	}

	public static String formatDateToOracle(Date dateToFormat) {
		Date data = new Date();
		SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formater.format(dateToFormat);
	}
	public static String formatDateToOracleV2(Date dateToFormat) {
		return dateToFormat != null ?new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateToFormat):null;
	}

	
}
