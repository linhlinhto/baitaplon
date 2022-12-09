package taotxt;

import java.io.FileWriter;

public class tao {
	public tao() {
		read();
	}
	public void read() {
		try	{
			FileWriter map1 = new FileWriter("map2.txt");
			for(int i=0 ;i<1088/16;i++) {
				for(int j=0;j<1920/16;j++) {
					if((i==27 && j==17) || (i==27 && j==97)) {
						map1.write("11 ");
					}
					else if(i==27&& j==54 || (i==27&& j==69)|| (i==39&&j==69) || (i==39&&j==54)) {
						map1.write("9 ");
					}
					else if(i==54||i==10){
						if(j==17||j==21||j==97||j==101) {
							map1.write("16 ");
						}
						else if(j==19||j==99) {
							map1.write("17 ");
						}
						else {
							map1.write("0 ");
						}
					}
					else if((i==12&&j==54)||(j==72&&i==21)||(i==54&&j==54)) {
						map1.write("12 ");
					}
					else if(j==34||j==80){
						if(i==18||i==51) {
							map1.write("19 ");
						}
						else {
							map1.write("0 ");
						}
						
					}
					else {
						map1.write("0 ");
					}
				}
				map1.write("\n");
			}
			map1.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String[] args) {
		tao tao = new tao();
	}
}
