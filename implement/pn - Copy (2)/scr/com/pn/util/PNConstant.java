package com.pn.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PNConstant {
	public static final String pathCongNo = "C:\\CongNo_KhachHang\\";
	private static final String[] hang_chuc = { "", " mười", " hai mươi",
		" ba mươi", " bốn mươi", " năm mươi", " sáu mươi", " bảy mươi",
		" tám mươi", " chín mươi" 
		};

	private static final String[] hang_don_vi = { "", " một", " hai", " ba",
		" bốn", " năm", " sáu", " bảy", " tám", " chín", " mươi",
		" mươi một", " mươi hai", " mươi ba", " mươi bốn", " mươi lăm",
		" mươi sáu", " mươi bảy", " mươi tám", " mươi chín" };
	public static String getDayFormat(Date date, String format) {
    	SimpleDateFormat dateFormat = new SimpleDateFormat(format);
    	return dateFormat.format(date);  	
	}
	
	private static String chuyen_so_nho_hon_1_nghin(int n) {
		String chuoi_so;
		if (n % 100 < 20) {
			chuoi_so = hang_don_vi[n % 100];
			n /= 100;
		} else {
			chuoi_so = hang_don_vi[n % 10];
			n /= 10;
			chuoi_so = hang_chuc[n % 10] + chuoi_so;
			n /= 10;
		}
		if (n == 0)
			return chuoi_so;
		return hang_don_vi[n] + " trăm" + chuoi_so;
	}

	public static String docSoSangChu(Double n) {
		if (n == 0) {
			return "không";
		}
		String snumber = Double.toString(n);
		String mask = "000000000000";
		DecimalFormat dec = new DecimalFormat(mask);
		snumber = dec.format(n);
		int Hang_Ty111411 = Integer.parseInt(snumber.substring(0, 3));
		int Hang_Trieu111411 = Integer.parseInt(snumber.substring(3, 6));
		int Hang_Tram_Nghin111411 = Integer.parseInt(snumber.substring(6, 9));
		int Hang_Nghin111411 = Integer.parseInt(snumber.substring(9, 12));

		String chuoiTy;

		switch (Hang_Ty111411) {
			case 0:
				chuoiTy = "";
				break;
			case 1:
				chuoiTy = chuyen_so_nho_hon_1_nghin(Hang_Ty111411) + " tỷ ";
				break;
			default:
				chuoiTy = chuyen_so_nho_hon_1_nghin(Hang_Ty111411) + " tỷ ";
		}
		String Kq111411 = chuoiTy;
		String chuoiTrieu;
		switch (Hang_Trieu111411) {
		case 0:
			chuoiTrieu = "";
			break;
		case 1:
			chuoiTrieu = chuyen_so_nho_hon_1_nghin(Hang_Trieu111411) + " triệu ";
			break;
		default:
			chuoiTrieu = chuyen_so_nho_hon_1_nghin(Hang_Trieu111411) + " triệu ";
		}

		Kq111411 = Kq111411 + chuoiTrieu;
		String chuoiTramNgan;
		switch (Hang_Tram_Nghin111411) {
		case 0:
			chuoiTramNgan = "";
			break;
		case 1:
			chuoiTramNgan = "một nghìn ";
			break;
		default:
			chuoiTramNgan = chuyen_so_nho_hon_1_nghin(Hang_Tram_Nghin111411) + " nghìn ";
		}
		Kq111411 = Kq111411 + chuoiTramNgan;
		String chuoingan = chuyen_so_nho_hon_1_nghin(Hang_Nghin111411);
		Kq111411 = Kq111411 + chuoingan;
		return Kq111411.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " ");
	}
}
