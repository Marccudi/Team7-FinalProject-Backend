package com.c6.replay.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.c6.replay.dto.Borrow;
import com.c6.replay.service.BorrowServiceImpl;

@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RequestMapping("/api")
public class BorrowController {
	
	@Autowired
	BorrowServiceImpl borrowServiceImpl;
	
	@GetMapping("/borrows")
	public List<Borrow> listBorrows(){
		return borrowServiceImpl.listBorrows();
	}
	
	@PostMapping("/borrows")
	public Borrow saveBorrow(@RequestBody Borrow borrow) {
		enviarConGMail(borrow.getUserOwner().getEmail(), "Peticion de prestamo", "El usuarios "+borrow.getUserBorrower().getUsername()+" pide prestado el juego "+borrow.getGame().getTitle());
		return borrowServiceImpl.saveBorrow(borrow);
	}
	
	@GetMapping("/borrows/{id}")
	public Borrow borrowXID(@PathVariable(name="id") Long id) {
		Borrow borrowXID = new Borrow();
		borrowXID=borrowServiceImpl.borrowXID(id);
		return borrowXID;
	}
	
	@GetMapping("/borrows/borrower/{id}")
	public List<Borrow> borrowsByBorrower(@PathVariable(name="id") int id) {
		return borrowServiceImpl.listByUserBorrower(id);
	}
	
	@PutMapping("/borrows/{id}")
	public Borrow updateBorrow(@PathVariable(name="id") Long id, @RequestBody Borrow borrow) {
		
		Borrow borrowSel = new Borrow();
		Borrow borrowAct =  new Borrow();
		
		borrowSel=borrowServiceImpl.borrowXID(id);
		
		borrowSel.setGame(borrow.getGame());
		borrowSel.setUserOwner(borrow.getUserOwner());
		borrowSel.setUserBorrower(borrow.getUserBorrower());
		borrowSel.setLend_date(borrow.getLend_date());
		borrowSel.setReturn_date(borrow.getReturn_date());
		
		borrowAct=borrowServiceImpl.updateBorrow(borrowSel);
		
		return borrowAct;
	}
	
	@PutMapping("/acceptborrow/{id}")
	public Borrow updateBorrow(@PathVariable(name="id") Long id, @RequestBody String returnDate) {
		
		Borrow borrowSel = new Borrow();
		Borrow borrowAct =  new Borrow();
		
		borrowSel=borrowServiceImpl.borrowXID(id);
		
		try {
			borrowSel.setLend_date(new Date());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
			date = sdf.parse(returnDate);
			borrowSel.setReturn_date(date);
			borrowSel.setPending(false);
			borrowSel.getGame().setBorrowed(true);
			
			borrowAct=borrowServiceImpl.updateBorrow(borrowSel);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return borrowAct;
	}
	
	@DeleteMapping("/borrows/{id}")
	public String deleteBorrow(@PathVariable(name="id") Long id) {
		try {
			borrowServiceImpl.deleteBorrow(id);
			return "Borrowing successfully deleted.";
		}catch (Exception e) {
			return "Error: you cannot delete this borrowing";
		}
	}
	
	@GetMapping("/borrows/user/{id}")
	public List<Borrow> listBorrowsUser(@PathVariable(name="id") Long id){
		return borrowServiceImpl.listBorrowByUser(id);
	}
	
	@GetMapping("/borrows/{id}/{state}")
	public List<Borrow> listBorrowsState(@PathVariable(name="state") boolean state, @PathVariable(name="id") Long id){
		return borrowServiceImpl.listBorrowByState(state, id);
	}

	@GetMapping("/borrows/owner/{id}")
    public List<Borrow> borrowsByBorrower(@PathVariable(name="id") Long id) {
        return borrowServiceImpl.listBorrowByUserOwner(id);
    }
	
	private static void enviarConGMail(String destinatario, String asunto, String cuerpo) {
	    // Esto es lo que va delante de @gmail.com en tu cuenta de correo. Es el remitente también.
	    String remitente = "replay";  //Para la dirección nomcuenta@gmail.com

	    Properties props = System.getProperties();
	    props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
	    props.put("mail.smtp.user", remitente);
	    props.put("mail.smtp.clave", "AIzaSyB53BsKeclH_NwPSpaF-iv6X4XvH4m8uig");    //La clave de la cuenta
	    props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
	    props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
	    props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

	    Session session = Session.getDefaultInstance(props);
	    MimeMessage message = new MimeMessage(session);

	    try {
	        message.setFrom(new InternetAddress(remitente));
	        message.addRecipients(Message.RecipientType.TO, destinatario);   //Se podrían añadir varios de la misma manera
	        message.setSubject(asunto);
	        message.setText(cuerpo);
	        Transport transport = session.getTransport("smtp");
	        transport.connect("smtp.gmail.com", remitente, "AIzaSyB53BsKeclH_NwPSpaF-iv6X4XvH4m8uig");
	        transport.sendMessage(message, message.getAllRecipients());
	        transport.close();
	    }
	    catch (MessagingException me) {
	        me.printStackTrace();   //Si se produce un error
	    }
	}
}
