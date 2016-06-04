$(document).ready( function() {
    
    $('.btn-group').find(':input:checked').parent('.btn').addClass('active');
    
    $('#repeticao').change( function () {
        if($('#repeticao').val() < 2) $('#prazo').hide();
        else $('#prazo').show();
    });
}); 