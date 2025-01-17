package team1.project.bookshop.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import team1.project.bookshop.exception.EmailException;
import team1.project.bookshop.exception.HashException;
import team1.project.bookshop.exception.MemberException;
import team1.project.bookshop.util.Message;

//하위 컨트롤러에서 해당 예외가 발생햇을때, 해당 하위 컨트롤러에서 지정된 @ExceptionHandler가 먼저 적용되고, 만일 해당 @ExceptionHandler가 지정되지않으면, 이 예외객체가 예외를 처리할 것임
//@RestControllerAdvice 자체가 RestController에서 발생하는 예외만 처리한다는 보장을 하지 않는다...
@RestControllerAdvice(annotations = RestController.class)  //ControllerAdvice + @ResponseBody
public class RestShopGlobalException {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@ExceptionHandler(value= {HashException.class})
	public ResponseEntity<Message> handle(HashException e){
		
		Message message = new Message();
		message.setMsg("쇼핑몰 글로벌 예외"+e.getMessage());
		
		ResponseEntity entity=new ResponseEntity<Message>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	};
	
	@ExceptionHandler(value= {EmailException.class})
	public ResponseEntity<Message> handle(EmailException e){
		
		Message message = new Message();
		message.setMsg("쇼핑몰 글로벌 예외"+e.getMessage());
		
		ResponseEntity entity=new ResponseEntity<Message>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	};
	
	@ExceptionHandler(value= {MemberException.class})
	public ResponseEntity<Message> handle(MemberException e){
		
		Message message = new Message();
		message.setMsg("쇼핑몰 글로벌 예외"+e.getMessage());
		
		ResponseEntity entity=new ResponseEntity<Message>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	};
}
