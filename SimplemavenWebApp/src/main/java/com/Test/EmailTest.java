package com.Test;
import com.Utils.EmailUtil;

public class EmailTest {
	public static void main(String[] args) throws Exception {
		// from,password,to,subject,message
		String subject = "B.E(E&TC)_Fresher _job application as a Java Developer";
		String message = "I am Rutuja Nandkumar Bagade applying for the job as a fresher.As I am quick learner and an innovative person,I can quickly adapt new technology thereby enhancing my skills and capabilities and i am suitable for this job opportunity.Kindly find my resume for additional information.I will be highly obliged if you offer me this post.Please let me know about it at my contact +91-9139251151.Thank you for your time and consideration.I look forward to speaking with you about this employment opportunity.";
		EmailUtil.send("rutujabagade8@gmail.com",subject, message);
		// change from, password and to
	}
}