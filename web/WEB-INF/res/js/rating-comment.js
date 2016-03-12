$(document).ready(function() {
    $('.ratings_star').hover(function() {
        var i=1;
        $('.glyphicon-star').each(function(){
            $(this).removeClass('glyphicon-star').addClass('glyphicon-star-empty');
        });
        var rating = $(this).data('rating'); // Get the rating from the selected star
        while(i<=rating){
            $('#star'+i).removeClass('glyphicon-star-empty').addClass('glyphicon-star'); // Adds the selected class to just the one you clicked
            i++;
        }
       var rating = $(this).data('rating'); // Get the rating from the selected star
       $('#rating').val(rating); // Set the value of the hidden rating form element
    });  
});




