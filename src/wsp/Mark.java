package wsp;

import java.io.Serializable;

public class Mark implements Serializable {
	   /**
	 * 
	 */
	private static final long serialVersionUID = -8627345658070953588L;
	private int firstAttestation;
	    private int secondAttestation;
	    private int finall;
	    private int total;
	    private Course course;
	    String markNow;
	    String grade;
	    
	    public Mark(int firstAttestation,int secondAttestation,int finall) {
	    	firstAttestation = 0;
	    	secondAttestation = 0;
	    	finall = 0;
	    }
	    
	    public Mark() {
	    	total = 0;
	    	firstAttestation = 0;
	    	secondAttestation = 0;
	    	finall = 0;
	    	markNow ="";
	    	grade = "";
	    }
	    
	    
	    private int getFirstAttestation() {
	        return this.firstAttestation;
	    }
	    int getSecondAttestation() {
	        return this.secondAttestation;
	    }
	    int getFinal() {
	        return this.finall;
	    }
	    String getmarkNow() {
	        return this.markNow;
	    }
	    void setmarkWhile(String markNow) {
	        this.markNow = markNow;
	    }
	    public Course getCourse() {
	        return this.course;
	    }
	    public void setCourse(Course course) {
	        this.course = course;
	    }
	    
	    void setFirstAttestation(int firstAttestation) {
	        this.firstAttestation = firstAttestation;  
	    }
	    void setSecondAttestation(int secondAttestation) {
	        this.secondAttestation = secondAttestation;
	    }
	    void setFinal(Integer finall) {
	        this.finall = finall;
	    }
	    
	    
	    private String getgrade() {
	    	total = firstAttestation + secondAttestation + finall;
	    	if(total > 95) return "A";
	    	else if (total > 90 && total < 95)
	    		return "A-";
	    	else if (total > 85 && total < 90)
	    		return "B+";
	    	else if (total > 80 && total < 85)
	    		return "B";
	    	else if (total> 75 && total < 80) 
	    		return "B-";
	    	else if (total > 70 && total < 75) 
	    		return "C+";
	    	else if (total > 65 && total < 70) 
	    		return "C";
	    	else if (total > 60 && total < 65)
	    		return "C";
	    	else if (total > 55 && total < 60) 
	    		return "D";
	    	else if (total > 50 && total < 55)
	    		return "D-";
			return "F";
	    	
	    }
	    
	    public String toString() {
	    	return "Mark: " + "firstAttestation: " + this.getFirstAttestation() + "SecondAttestation: " + 
	    			this.getSecondAttestation() + "Final: " + this.getFinal();
	    }
	    
}
