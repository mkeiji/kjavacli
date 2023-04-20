package com.example.demo.commands;

import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class HelloWorld {

	@ShellMethod(key = "hello-world")
	public String helloWorld(
		@ShellOption(defaultValue = "spring") String arg
	) {
		return "Hello world " + arg;
	}

	@ShellMethod(key = "getos")
	public String getos() {
        return String.format("host os: %s", System.getProperty("os.name"));
	}

	@ShellMethod(key = "cmd")
	public void ls(String cmd) throws Exception {
        ProcessBuilder builder = new ProcessBuilder();
        builder.command("sh", "-c", cmd);
        builder.directory(new File(System.getProperty("user.home")));

        Process process = builder.start();

        StreamGobbler streamGobbler = new StreamGobbler(
                process.getInputStream(), System.out::println);

        Future<?> future = Executors.newSingleThreadExecutor().submit(streamGobbler);

        int exitCode = process.waitFor();
        assert exitCode == 0;

        future.get(10, TimeUnit.SECONDS);
	}
}
