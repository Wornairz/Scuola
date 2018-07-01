<?php
// define variables and set to empty values
$nome = $cognome = $sesso = $datan = $email = $psw = "";
$tuttok = true;

if ($_SERVER["REQUEST_METHOD"] == "POST") {
  test_nome($_POST["nome"]);
  test_cognome($_POST["cognome"]);
  test_sesso($_POST["sesso"]);
  test_datan($_POST["datan"]);
  test_email($_POST["email"]);
  test_psw($_POST["psw"]);

  echo 'Tu sei ' . $GLOBALS["nome"] . ' ' . $GLOBALS["cognome"] . '</br>';
  if($tuttok){
    echo "<h1>I controlli sono andati a buon fine. Buon proseguimento!</h1>";
  }
  else{
    echo "<h1>Uno o più errori si sono verificati durante la registrazione. Guarda sopra per capire quali campi modificare. Per favore, torna indietro e correggi i campi.</h1>";
  }
}
function test_nome($data){
  test_input($data);
  if(strlen($data)<=4){
     global $tuttok;
     $tuttok=false;
     echo "Il nome inserito è troppo corto.<br>";
  }
  else{
     $GLOBALS['nome'] = $data;
     
  }
}
function test_cognome($data){
  test_input($data);
  if(strlen($data)<=4){
     global $tuttok;
     $tuttok=false;
     echo "Il cognome inserito è troppo corto.<br>";
  }
  else{
     $GLOBALS['cognome'] = $data;
  }
}
function test_datan($data){
  test_input($data);
  if(strlen($data)<8){
     global $tuttok;
     $tuttok=false;
     echo "Inserisci una data di nascita valida. <br>";
  }
  else{
     $GLOBALS['datan'] = $data;
  }
}
function test_sesso($data){
  test_input($data);
  if($data==""){
     global $tuttok;
     $tuttok=false;
     echo "Devi selezionare un sesso!<br>";
  }
  else{
     $GLOBALS['sesso'] = $data;
  }
}
function test_email($data){
  test_input($data);
  if (!filter_var($data, FILTER_VALIDATE_EMAIL)) {
     global $tuttok;
     $tuttok=false;
     echo "L'indirizzo email ($data) non va bene. <br>";
  }
  else{
     $GLOBALS['email'] = $data;
  }
}
function test_psw($data){
  test_input($data);
  if(strlen($data)<8){
     global $tuttok;
     $tuttok=false;
     echo "La password deve contenere almeno 8 caratteri! <br>";
  }
  else{
     $GLOBALS['psw'] = $data;
  }
}
function test_input($data) {
  $data = trim($data);
  $data = stripslashes($data);
  $data = htmlspecialchars($data);
  return $data;
}
?>