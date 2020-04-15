package CalcularIdade;

public class dataRegra {
	private byte dia;
	private byte mes;
	private short ano;
	
	public dataRegra(int dia, int mes, int ano ) {
		setData31(dia, mes, ano);
		setData30(dia, mes, ano);
		setDataFevereiro(dia, mes, ano);
	}
	
	
	public void setData31(int dia, int mes, int ano) {
		if (ano >= 1500 && ano <= 2020) {
			this.ano= (short)ano;
			}else {
			throw new RuntimeException("O ano "+ano+" é  invalido");
			}
			if(mes==1 || mes==3 || mes==5 || mes==7 || mes==8 || mes==10 || mes==12) {
				this.mes= (byte)mes;
				}else if (mes < 1 || mes > 12) {
				throw new RuntimeException("O mes "+mes+" é invalido");
				}if(dia>=1 && dia<=31) {
					this.dia = (byte)dia;
					}else {
						throw new RuntimeException("O valor "+dia+" é um dia invalido");
						}
				
			}
		
	
	
	
	public void setData30(int dia, int mes, int ano) {
		if (ano >= 1500 && ano <= 2020) {
			this.ano= (short)ano;
			}else {
			throw new RuntimeException("O ano "+ano+" é  invalido");
			}
			if(mes==4 || mes==6 || mes==9 || mes==11) {
				this.mes= (byte)mes;
			}else if (mes < 1 || mes > 12) {
				throw new RuntimeException("O mes "+mes+" é invalido");
			}if(dia>=1 && dia<=30) {
					this.dia = (byte)dia;
					}else {
						throw new RuntimeException("O valor "+dia+" é um dia invalido");
						}
				
			}
		
	public void setDataFevereiro(int dia, int mes, int ano) {
	 if (ano >= 1500 && ano <= 2020 ){
			this.ano= (short)ano;
			if(mes==2) {
				this.mes= (byte)mes;
				}else if (mes < 1 || mes > 12) { 
				throw new RuntimeException("O mes "+mes+" é invalido");
				}if(dia>=1 && dia<=29 ) {
					this.dia = (byte)dia;
					}else {
						throw new RuntimeException("O dia "+dia+" é invalido");
					}
			
				
			}
		}
	@Override
	public String toString() {
		return this.dia + "/" + this.mes +"/"+ this.ano;
	}

}
