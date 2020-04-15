package CalcularIdade;
import javax.swing.text.MaskFormatter;

public class Formatacao {

	public static String formatarData(String value) {

		MaskFormatter mf;

		mf = new MaskFormatter();
		mf.setValueContainsLiteralCharacters(false);
		value.replaceAll("([0-9]) ", "$1");
		value.replace("/", "");
		value.replaceAll("-", "");

		String formatado = value.substring(0, 2) + "/" + value.substring(2, 4) + "/" + value.substring(4, 8);

		return formatado;

	}

}
