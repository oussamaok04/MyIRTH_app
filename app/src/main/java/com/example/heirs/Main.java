package com.example.heirs;

import com.example.irth.Calculator;
import com.example.irth.R;
import com.example.rules.*;

public class Main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator cal = new Calculator();
		Deceased deceased = new Deceased(cal.getgender());

		deceased.setLegacy(cal.getlegacy());


		if ()
		deceased.addHeir();

	}

}
