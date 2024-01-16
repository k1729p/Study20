package kp.client;

import java.lang.module.ModuleDescriptor;
import java.util.ServiceLoader;
import java.util.ServiceLoader.Provider;
import java.util.stream.Stream;

import kp.service.KpService;
import kp.utils.Printer;

/**
 * The <b>KpService</b> service consumer.
 *
 */
public class KpServiceClient {

	/**
	 * The constructor.
	 */
	public KpServiceClient() {
		super();
	}

	/**
	 * The main method.
	 * 
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		Printer.printHor();
		Stream.of(KpService.class, KpServiceClient.class)//
				.map(Class::getModule).map(Module::getDescriptor).map(ModuleDescriptor::toString)
				.forEach(Printer::print);
		Printer.printHor();

		Printer.print("All provided services:");
		ServiceLoader.load(KpService.class).stream().map(Provider::get)//
				.forEach(arg -> Printer.printf("Service result[%s]%n", arg.launch()));
		Printer.printHor();

		Printer.print("Only simple service:");
		ServiceLoader.load(KpService.class).stream().map(Provider::get).filter(KpService::isSimple)//
				.forEach(arg -> Printer.printf("Service result[%s]%n", arg.launch()));
		Printer.printHor();
	}
}