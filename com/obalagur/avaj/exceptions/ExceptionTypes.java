package obalagur.avaj.exceptions;

public enum ExceptionTypes {
	NOT_DIGIT{
		@Override
	    public String toString() {
	        return putInBrackets("INVALID input (digit data excpected) Exception");
	    }
	},
	NO_TYPE{
		@Override
	    public String toString() {
	        return putInBrackets("INVALID input (aircraft type) Exception");
	    }
	},
	NO_DATA{
		@Override
	    public String toString() {
	        return putInBrackets("INVALID input (content size) Exception");
	    }
	},
	NO_HASH{
		@Override
	    public String toString() {
	        return putInBrackets("INVALID hashed input Exception");
	    }
	},
	EMPTY_INPUT{
		@Override
	    public String toString() {
	        return putInBrackets("EMPTY input Exception");
	    }
	},
	NO_FILE{
		@Override
	    public String toString() {
	        return putInBrackets("NO INPUT (scenario wasnt setted) Exception");
	    }
	},
	NULL_INPUT{
		@Override
	    public String toString() {
	        return putInBrackets("NULL input Exception");
	    }
	};
	
	private static String putInBrackets(String msg) {
		return ("\n\n< " + msg + " >\n");
	}
}
