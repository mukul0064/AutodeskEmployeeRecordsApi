package com.autodesk;

//Author's email address: mukul0064@gmail.com

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class MainApplication {

	public static void main(String... args) {
		Quarkus.run(Application.class);
	}

	public static class Application implements QuarkusApplication {

		@Override
		public int run(String... args) throws Exception {
			Quarkus.waitForExit();
			return 0;
		}
	}
}
