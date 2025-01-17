package team1.project.bookshop.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import team1.project.bookshop.exception.AdminException;
import team1.project.bookshop.util.Message;

/*관리자와 관련된 글로벌 예외처리 객체
 * 단 응답형식은 jsp가 아닌 json 과 같은 데이터형태가 되어야 하므로,
 * ResponseEntity로 응답한다*/

//@RestControllerAdvice = ControllerAdvice + @ResponseBody
//@RestControllerAdvice(annotations = RestController.class)  = RestController에서
//발생한 예외만 잡는다
@RestControllerAdvice(annotations = RestController.class) 
public class RestAdminGlobalException {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@ExceptionHandler(value= {AdminException.class})
	public ResponseEntity<Message> handle(RuntimeException e){
		logger.info("관리자의 Rest 글로벌 예외에서 감지한 회원등록 실패");
		
		Message message = new Message();
		message.setMsg("Admin Rest 글로벌 예외: "+e.getMessage());
		
		ResponseEntity entity = new ResponseEntity<Message>(message, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}
}
