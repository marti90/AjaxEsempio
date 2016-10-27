/**
 * 
 */

$(document).ready(function(){
	
	$("#btn").click(function(){
		
		var datoInserito= $("#txt").val();
		//alert(datoInserito);
		
		//parametri dentro url = http://...?matricola=valoreInDatoInserito
		var parametroInput= "matricola="+datoInserito;
		
		$.ajax({
			//request fatta tramite ajax
			type:"POST",
			url:"prendiStudente",
			//devo definire il dato da mandare da lato client a lato server
			data:parametroInput,
			//risposta che torna deve essere in formato json
			dataType:"JSON",
			
			//se tutto è andato bene possiamo definire una function anonimo che deve fare
			//quello che le scriviamo dentro. Lo status(se 4.. allora c'è un errore lato client,
			//se 5.. c'è un errore lato server, se 2.. allora è tutto a posto
			//jq Xml Http Request è un oggetto di JavaScript
			success: function(data,txtStatus,jqXHR){
				//se tutto è andato bene e vengono ricevuti i dati 
				//l'oggetto json che viene passato è in data
				
				if(data.success){
					//voglio scriverlo dentro il div con id=risposta
					$("#risposta").html("");
					$("#risposta").append("<p>Nome="+data.studente.nome+"</p>");
					$("#risposta").append("<p>Cognome="+data.studente.cognome+"</p>");
				}else{
					$("#risposta").html("");
					$("#risposta").append("<p>Quello studente non esiste!</p>");
				}
			},
		    
			//se è successo qualcosa che non va e non abbiamo ricevuto niente
		    error: function(txtStatus,jqXHR,erroreLanciato){
		    	console.log("Qualcosa e' andato storto: "+txtStatus);
		    }
			
		});
		
	});
	
});

