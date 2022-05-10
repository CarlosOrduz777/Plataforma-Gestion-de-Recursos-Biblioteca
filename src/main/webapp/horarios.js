/**
* Calendario
**/



/**
* Funcion que valida y despliega si el evento va a hacer recurrente
*/
function esRecurrente() {
  // Get the checkbox
  var checkBox = document.getElementById("myCheck");
  // Get the output text
  var recurrente = document.getElementById("recurrente")

  // If the checkbox is checked, display the output text
  if (checkBox.checked == true){
    recurrente.style.display = "block";
  } else {
    recurrente.style.display = "none";
  }
}


/**
* Valida campos de reserva
**/
function validaForm(){
    // Campos de texto
    if($("#nombre").val() == ""){
        alert("El campo Nombre no puede estar vacío.");
        $("#nombre").focus();       // Esta función coloca el foco de escritura del usuario en el campo Nombre directamente.
        return false;
    }
    if($("#apellidos").val() == ""){
        alert("El campo Apellidos no puede estar vacío.");
        $("#apellidos").focus();
        return false;
    }
    if($("#direccion").val() == ""){
        alert("El campo Dirección no puede estar vacío.");
        $("#direccion").focus();
        return false;
    }

    // Checkbox
    if(!$("#mayor").is(":checked")){
        alert("Debe confirmar que es mayor de 18 años.");
        return false;
    }

    return true; // Si todo está correcto
}