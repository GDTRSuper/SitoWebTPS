$(document).ready(function() {
    $('.ratings_star').click(function() {
       $('.ratings_star').removeClass('glyphicon glyphicon-star-empty'); // Removes the selected class from all of them
       $(this).addClass('glyphicon glyphicon-star'); // Adds the selected class to just the one you clicked

       var rating = $(this).data('rating'); // Get the rating from the selected star
       $('#rating').val(rating); // Set the value of the hidden rating form element
    });  
});




