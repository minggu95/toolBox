jQuery(document).ready(function() {
    showDetails();
    function  showDetails(){
        var companyCode=  jQuery("#field28380").val();
        for(i=0;i<9;i++){
            n=i+1;
            if($("#indexnum"+i).val()>0){
                $("#mx"+n).show();
            }else{
                if(companyCode != '51' && companyCode != '11') {
                    if(n != 5){
                        $("#mx"+n).hide();
                    }
                }  else {
                    $("#mx"+n).hide();
                }
            }
        }
        $("#behalf").hide();
        if($("#field28376").val() == '') {
            $("#con").hide();
        }
        /*
        供应商的显隐
        */
        if($("#field30969").val() == '') {
            $("#field30969_tdwrap").parent().hide();
        }
        /*
        出差报告行
        */
        if($("#field30285").val() == '') {
            $("#field30285_tdwrap").parent().hide();
        }
        var bud2 = jQuery("#field28502").val();
        var billType = jQuery("#field28375").val() ;
        if(billType == "grjk" || billType  == "dgyfkyes" || billType  == "dgyfkno" || billType  == "shbzyf"){
            $("#mx5").hide();
        }
        if(bud2  != "" && bud2 == "7.02") {
            $("#mx5").hide();
        }
    }
});