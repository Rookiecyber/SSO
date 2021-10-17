$(document).ready(function(){
		
$('.photo_slider').each(function(){
	
	var $this = $(this).addClass('photo-area');
	var $img = $this.find('img');
	var $info = $this.find('.info_area');
		
	var opts = {};
	
	$img.ready(function(){
		opts.imgw = $img.width();
		opts.imgh = $img.height();
	});
	
	opts.orgw = $this.width();
	opts.orgh =  $this.height();
	
	$img.css ({
		marginLeft: "-150px",
		marginTop: "-150px"
	});
	
	var $wrap = $('<div class="photo_slider_img">').append($img).prependTo($this);

	var $open = $('<a href="#" class="more_info">More Info &gt;</a>').appendTo($this);
	
	var $close = $('<a class="close">Close</a>').appendTo($info);
	
	opts.wrapw = $wrap.width();
	opts.wraph = $wrap.height();
	
	$open.click(function(){
		$this.animate({ 
			width: opts.imgw,
			height: (opts.imgh+95),
			borderWidth: "10"
			
		}, 600 );
				
		$open.fadeOut();
		
		$wrap.animate({ 
		    width: opts.imgw,
			height: opts.imgh
		}, 600 );

		$(".info_area",$this).fadeIn();
		
		$img.animate({
			marginTop: "0px",
			marginLeft: "0px"
		}, 600 );
		
		return false;
	});
	
	$close.click(function(){
		$this.animate({ 
			width: opts.orgw,
			height: opts.orgh,
	        borderWidth: "1"
	      }, 600 );
		
		$open.fadeIn();
		
		$wrap.animate({ 
	        width: opts.wrapw,
			height: opts.wraph
		      }, 600 );
		
			$img.animate({
				marginTop: "-150px",
				marginLeft: "-150px"
			}, 600 );

		$(".info_area",$this).fadeOut();
		return false;
	});
	
});

});