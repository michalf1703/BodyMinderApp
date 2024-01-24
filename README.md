# BodyMinder - Android App

We are pleased to present BODY MINDER, an innovative general health application that enables effective monitoring of habits nutritional, offers personalized physical activities, provides balanced diets, and supports the user's overall physical development.

## Prerequisites

Make sure you have the following installed on your machine:

- [Android Studio](https://developer.android.com/studio)
- [Git](https://git-scm.com/)

## Getting Started

1. **Clone the repository to your local machine:**
    ```bash
    git clone https://github.com/michalf1703/BodyMinderApp.git
    ```

2. **Open Android Studio and select "Open an existing Android Studio project."** Navigate to the cloned repository and select the "MobileSystems" directory.

3. **Create a `local.properties` file in the project root and set the path to your Android SDK:**
    ```properties
    sdk.dir=/path/to/your/android/sdk
    ```
    Replace `/path/to/your/android/sdk` with the actual path to your Android SDK.


4. **Firebase Authentication:**
   - The project uses Firebase Authentication for secure user registration and login.
   - User credentials and data are securely managed through Firebase Authentication.

5. **Build and run the project using Android Studio.**

## Project Functionalities

#### Feature 1: Login & Registration 
- Secure login panel for registered users.
- Simple registration process for new users.
- If the user forgets their password, they can change it via e-mail.

#### Feature 2:  BMI Calculator
- An easy-to-use interface where the user enters gender data, current weight, age and height.
- The app automatically calculates and presents BMI and BMI information ranges of values.

#### Feature 3:  Caloric Requirement Calculator
-  An interactive form in which the user provides their gender, current weight, height, age, and chooses a goal (lose weight, maintain weight, gain weight).
- The algorithm precisely calculates the daily caloric needs, adjusting them for your purposes.

#### Feature 4: Meal suggestions
- A rich database of recipes for healthy breakfasts, lunches and dinners.
- Each recipe contains information on ingredients and quantities Calories.

#### Feature 5: Suggestions for physical activities
- A training plan that includes short, intense workouts for different parts of the body.
- Integration with workout videos available on YouTube, providing additional visual support

#### Feature 6: Adding Meals
- A section that allows you to add the meals you have eaten.
- Introduced meals are analyzed in terms of calorific value, based on the on nutritional values.
- The user can also add the calorie content of the finished dish

#### Feature 7: Counting calories eaten & suggested physical activity
- If the user exceeds his calorie limit, information will be displayed about possible physical activities that will help burn this caloric surplus.

## License

This project is licensed under the [Apache License 2.0](LICENSE).
