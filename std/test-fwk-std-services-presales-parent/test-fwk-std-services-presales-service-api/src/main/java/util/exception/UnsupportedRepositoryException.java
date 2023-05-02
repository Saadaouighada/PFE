package util.exception;

/**
 * The Class UnsupportedRepositoryException.
 *
 * @author THouissa
 */
public class UnsupportedRepositoryException extends Exception{

	/**
	 * Instantiates a new unsupported repository exception.
	 */
	public UnsupportedRepositoryException(String repositoryUrl) {
		System.err.println("The repository: "+repositoryUrl+" is not yet supported.");
	}

}
