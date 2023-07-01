$(document).ready(function(){
    (function(){
        $.ajax({
            type : "GET",
            url : "/pacientes",
            success: function(response){
              $.each(response, (i, paciente) => {
                let getMoreInfoBtn = '<button' +
                    ' id="btn_id_' + paciente.id + '"' +
                    ' type="button" class="btn btn-info btn_id">' +
                    paciente.id +
                    '</button>';

                let trId = 'tr_' + paciente.id;
                let pacienteRow = '<tr id="' + trId + '">' +
                    '<td>' + getMoreInfoBtn + '</td>' +
                    '<td class="td_nombre">' + paciente.nombre.toUpperCase() + '</td>' +
                    '<td class="td_apellido">' + paciente.apellido + '</td>' +
                    '<td class="td_dni">' + paciente.dni + '</td>' +
                    '<td class="td_fecha_alta">' + paciente.fechaAlta + '</td>' +
                    '<td class="td_domicilio">' +
                    'Calle: ' + paciente.domicilio.calle + ', ' +
                    'Número: ' + paciente.domicilio.numero + ', ' +
                    'Localidad: ' + paciente.domicilio.localidad + ', ' +
                    'Provincia: ' + paciente.domicilio.provincia +
                    '</td>' +
                    '</tr>';

                $('#pacienteTable tbody').append(pacienteRow);
              });
            },
            error : function(e) {
              alert("ERROR: ", e);
              console.log("ERROR: ", e);
            }
        });
    })();

    (function(){
        let pathname = window.location.pathname;
        if (pathname == "/pacientes.html") {
            $(".nav .nav-item a:last").addClass("active");
        }
    })();
});
