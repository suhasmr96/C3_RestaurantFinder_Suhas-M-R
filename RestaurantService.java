import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException{
        for(Restaurant restaurant : restaurants)
        {
            if(restaurant.getName().equals(restaurantName))
            {
                return restaurant;
            }
            else if(restaurant.getName() == null)
            {
                throw new restaurantNotFoundException("No Restaurant Found with that name");
            }
        }
        return null;

    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException
    {
        try
        {
            Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
            restaurants.remove(restaurantToBeRemoved);
            return restaurantToBeRemoved;
        }
        catch (Exception e)
        {
            throw new restaurantNotFoundException(restaurantName);
        }


    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
