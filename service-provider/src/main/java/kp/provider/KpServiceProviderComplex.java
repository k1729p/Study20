package kp.provider;

import kp.service.KpService;

/**
 * The provider of a complex <b>KpService</b> service implementation.
 *
 */
public class KpServiceProviderComplex {
	/**
	 * The constructor.
	 */
	private KpServiceProviderComplex() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Obtains an instance of the service.
	 *
	 * @return the service instance
	 */
	public static KpService provider() {

		return new KpService() {
			/**
			 * {@inheritDoc}
			 */
			@Override
			public boolean isSimple() {
				return false;
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			public String launch() {
				return "Message from «complex» KP service";
			}
		};
	}
}