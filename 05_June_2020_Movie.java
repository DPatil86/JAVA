import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int movieId, rating, budget;
        String director;
        Movie[] movies = new Movie[4]; //creating array of movie objects
        for(int i=0;i<4;i++){
            movieId = s.nextInt();s.nextLine();
            director = s.nextLine();
            rating = s.nextInt();
            budget = s.nextInt();
            movies[i] = new Movie(movieId, director, rating, budget);
        }
        s.nextLine();
        String findDirector = s.nextLine();
        int findRating = s.nextInt();
        int findBudget = s.nextInt();
        int findAvg = findAvgBudgetByDirector(movies, findDirector); //calling method
        if(findAvg > 0){
            System.out.println(findAvg);
        }
        else
            System.out.println("Sorry - The given director has not directed any movie yet");
        Movie m = getMovieByRatingBudget(movies, findRating, findBudget); //calling method
        if(m == null)
            System.out.println("Sorry - No movie available at specified rating and budget requirement");
        else
            System.out.println(m.getMovieId());
    }
    public static int findAvgBudgetByDirector(Movie[] movies, String director){
        int sum = 0,count=0;
        for(int i=0;i<4;i++){
            if(director.equalsIgnoreCase(movies[i].getDirector())){ //if required director matches with existing directors in the array of objects
                count++;
                sum += movies[i].getBudget(); //adding the movie budgets
            }
        }
        if(sum>0)
            return sum/count; //returing the average movie budget
        else
            return 0;
    }
    public static Movie getMovieByRatingBudget(Movie[] movies, int rating, int budget){
        Movie m = new Movie();
        for(int i=0;i<4;i++){
            if(movies[i].getRating()==rating && movies[i].getBudget()==budget){ //if rating and budget matches, then we need to return that object to main method.
                if(movies[i].getBudget()%movies[i].getRating() == 0){
                    m = movies[i];
                    return m;
                }
            }
        }
        return null;
    }
}
 
class Movie{
    int movieId,rating,budget;
    String director;
    Movie(){}
    Movie(int movieId, String director, int rating, int budget){
        super();
        this.movieId = movieId;
        this.director = director;
        this.rating = rating;
        this.budget = budget;
    }
    int getMovieId(){
        return movieId;
    }
    String getDirector(){
        return director;
    }
    int getRating(){
        return rating;
    }
    int getBudget(){
        return budget;
    }
}
