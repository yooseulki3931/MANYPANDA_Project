/* eslint-disable */
export default function dapandaDetail(){
    (function(){
        var $container = $DF('.df-installment-wrap');
        if(!$container.length) return;
        var $tab_link = $container.find('.df-installment-tab_link');
        $tab_link.on('click', function(){
            var $this = $DF(this);
            var index = $this.attr('data-index');
            $this.parent().addClass('selected').siblings().removeClass('selected');
            var $content = $container.find('.df-installment-content');
            $content.removeClass('active').filter('.df-installment-content_'+index).addClass('active');
        });
        var $btn_open = $DF('.df-installment-btn_open');
        $btn_open.on('click', function(){
            $container.addClass('active');
        });
        var $btn_close = $DF('.df-installment-btn_close');
        $btn_close.on('click', function(){
            $container.removeClass('active');
        });
    })();
}