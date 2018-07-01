        var operatore=null, operando1=null, operando2=null, risultato='';
          /*$('document').ready(function () {
            var operatori = document.getElementsByName("operatore");
            for(i=0;i<operatori.length;i++){
                operatori.item(i).onclick = function(){
                operatore=operatori.item(i).textContent;
              }
            }
          });*/
          function operathore(valore){
            if(operando2==null && operando1!=null){
                operatore=valore;
                document.getElementById('risultato').value += valore;    
            }
          }
          function operando(valore){
            if(!risultato.includes("=")){
                if(operando1!=null && operatore!=null){
                    if(operando2!=null) operando2+=valore;
                    else operando2=valore;
                }
                else{
                    if(operando1!=null) operando1+=valore;
                    else operando1=valore;
                }
                document.getElementById('risultato').value += valore;
            }
          }
          function calcola(){
              switch(operatore){
                  case '+':{
                      risultato=eval(operando1)+eval(operando2);
                      break;
                  }
                  case '-':{
                      risultato=eval(operando1)-eval(operando2);
                      break;
                  }
                  case '*':{
                      risultato=eval(operando1)*eval(operando2);
                      break;
                  }
                  case '/':{
                      risultato=eval(operando1)/eval(operando2);
                      break;
                  }
              }
              if(operatore!=null) document.getElementById('risultato').value += '=' + risultato;
          }
          function pulisci(){
              document.getElementById('risultato').value = '';
              operando1=null; operando2=null;operatore=null; risultato='';
          }
          function Fnumeri(g)
          {
              console.log("ciao" + g);
            document.getElementById("usr").value+=g;
          }
          function Fuguale()
          {
              
              risultato = eval(document.getElementById("usr").value);
              document.getElementById("usr").value+="="+risultato;
          }
          function Fcancella()
          {
             document.getElementById("usr").value = document.getElementById("usr").value.slice(0, document.getElementById("usr").value.length-1);
          }