package wsp;

import java.io.Serializable;

public class CourseFile implements Serializable {
	
		
		/**
	 * 
	 */
	private static final long serialVersionUID = -6829211848453664764L;
		public String topic;
		public String text;
		public String sender;
		
		public CourseFile() {}
		public CourseFile(String topic,String text){
			this.topic = topic;
			this.text = text;
		}
		
		
		public String getTopic() {
			return topic;
		}

		public String getText() {
			return text;
		}


		public void setText(String text) {
			this.text = text;
		}




		public void setTopic(String topic) {
			this.topic = topic;
		}

		public boolean equals(Object o) {
			return false;
		}
		public String toString() {
	        return "CourseFile topic" + this.getTopic() + "  text:" + this.getText();
	    }
		
}
