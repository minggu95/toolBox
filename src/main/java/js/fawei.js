<script type="text/javascript">
    /*
    *  TODO
     *  请在此处编写javascript代码
     */
    jQuery(document).ready(function() {
        function sffb_change() {
            if($('#field21190').val()=="0"){
                $('tr[name=gs1]').show();
                $('tr[name=gs2]').show();
                $('tr[name=gs3]').show();
            }else
            {
                $('tr[name=gs1]').hide();
                $('tr[name=gs2]').hide();
                $('tr[name=gs3]').hide();
                $("#oTable1 tr[_target='datarow']").remove();
                $("#nodesnum1").val(0);
                $("#oTable2 tr[_target='datarow']").remove();
                $("#nodesnum2").val(0);
            }
        }
        sffb_change();
        $('#field21190').bindPropertyChange(function() {
            sffb_change();
        });
    });
</script>