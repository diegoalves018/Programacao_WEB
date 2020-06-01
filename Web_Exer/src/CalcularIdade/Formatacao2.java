package CalcularIdade;

import javax.swing.text.MaskFormatter;

public class Formatacao2 {

	public static String formatarData2(String value) {

		MaskFormatter mf;

		mf = new MaskFormatter();
		mf.setValueContainsLiteralCharacters(false);
		value.replaceAll("([0-9]) ", "$1");
		value.replace("/", "");
		value.replaceAll("-", "");

		String formatado2 = value.substring(4, 8) + "-" + value.substring(2, 4) + "-" + value.substring(0, 2);

		return formatado2;

	}

}

