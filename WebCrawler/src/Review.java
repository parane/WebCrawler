
public class Review {
private String review;
private String resturant;
public Review(String review, String resturant)
{
	this.review=review;
	this.resturant=resturant;
	
}
public String getReview()
{
	return review;
}

public String getResturant()
{
	return resturant;
}

public boolean equals(Object c) {
    if(!(c instanceof Review)) {
        return false;
    }

    Review that = (Review)c;
    return this.review.equals(that.getReview()) && this.resturant.equals(that.getResturant());
}
}
