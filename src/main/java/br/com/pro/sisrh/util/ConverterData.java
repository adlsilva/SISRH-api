package br.com.pro.sisrh.util;

import java.io.Serializable;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class ConverterData implements Serializable{
	private static final long serialVersionUID = 694981992275210506L;

	
	//dado = new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy", Locale.US).parse(ddt));
	
	public String dataEmString(Date data) {
		Date dataAtual = data;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String dataFormatada = dateFormat.format(dataAtual);
		return dataFormatada;
	}

	public String dataEmStringBrasil(Date data) {
		Date dataAtual = data;
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = dateFormat.format(dataAtual);
		return dataFormatada;
	}

	public Date stringEmData(String data) {
		Date date1 = null;
		try {
			date1 = (Date) new SimpleDateFormat("yyyy/MM/dd").parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date1;
	}
	
	public Date stringEmDataTraco(String data) {
		Date date1 = null;
		try {
			date1 = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date1;
	}

	public LocalDate dataEmLocalData(Date data) {
		// Instant instant = data.toInstant();
		// ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault());
		// LocalDate date = zdt.toLocalDate();
		LocalDate localDate = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return localDate;
	}

	public Date localDateEmData(LocalDate data) {
		Date date1 = (Date) Date.from(data.atStartOfDay(ZoneId.systemDefault()).toInstant());
		return date1;
	}

	public String localDataEmStringEUA(LocalDate data) {
		return data.toString();
	}

	public String localDataEmStringBRA(LocalDate data) {
		String formattedDate = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return formattedDate;
	}

	public String dataEmCalendarAcerto1EUA(Date data) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.DATE, 0);
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy/MM/dd");
		String dt= format1.format(cal.getTime());
		return dt;
	}
	
	public String dataEmCalendarAcerto1BRA(Date data) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.DATE, 0);
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
		String dt= format1.format(cal.getTime());
		return dt;
	}
}
