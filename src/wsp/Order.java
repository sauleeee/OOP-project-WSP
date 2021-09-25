package wsp;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable{
	    /**
	 * 
	 */
	private static final long serialVersionUID = 4982361347594539388L;
		private String sender;
	    private String topic;
	    private String text;
	    private Date date;
	    private OrderType type;
	    private Executor executor;
	    
	    
	    public Order() {}
	    public Order(String topic,String text,Date date,String sender) {
	       this.topic = topic;
	       this.text = text;
	       this.type = type.AWAITING;
	       this.date = date;
	       this.sender = sender;
	      
	    }
	    
	    String getSender() {
	        return this.sender;
	    }
	    
	    private void setSender(String sender) {
	        this.sender = sender;
	    }
	    
		String getTopic() {
	        return this.topic;
	    }
	    private void setTopic(String topic) {
	        this.topic = topic;
	    }
	    String getText() {
	        return this.text;
	    }
	    private void setText(String text) {
	        this.text = text;
	    }
	   
	    Date getDate() {
	        return this.date;
	    }
	    private void setDate(Date date) {
	        this.date = date;
	    }
	  
	    public void accept(Executor e) {
	        type = OrderType.ACCEPTED;
	        
	    }
	    
	    public void reject() {
	        type = OrderType.REJECTED;
	    }
	    
	    public void execute() {
	        type = OrderType.DONE;
	    }
	    public String toString() {
	        return "Sender:" + this.getSender() + "  Topic:" + this.getTopic() + "  Text:" + this.getText() + " date of send:" + this.getDate();
	    }
	    
		public OrderType getType() {
			return type;
		}
		public void setType(OrderType type) {
			this.type = type;
		}
		public int compareTo(Order o){
		     return topic.compareTo(o.getTopic());
	   }

}
