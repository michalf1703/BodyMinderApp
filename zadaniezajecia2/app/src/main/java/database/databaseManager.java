package database;

import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class databaseManager {
    private final FirebaseAuth mAuth;
    private final FirebaseUser user;
    private final FirebaseFirestore db;

    public databaseManager() {
        db = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
    }
    public void addUserCaloriesData( double calculatedCalories) {
        if (user != null) {
            db.collection("users")
                    .document(user.getUid())
                    .set(new User(user.getUid(), user.getEmail(), calculatedCalories))
                    .addOnSuccessListener(aVoid -> {
                        System.out.println("Dane użytkownika zostały dodane pomyślnie.");
                    })
                    .addOnFailureListener(e -> {
                        System.err.println("Błąd podczas dodawania danych użytkownika: " + e.getMessage());
                    });
        } else {
            System.err.println("Użytkownik nie jest zalogowany.");
        }
    }

    public void getCaloriesForUser(CaloriesCallback callback) {
        if (user != null) {
            DocumentReference userDocument = db.collection("users").document(user.getUid());

            userDocument.get()
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            DocumentSnapshot document = task.getResult();

                            if (document != null && document.exists()) {
                                double calories = document.getDouble("calories");
                                callback.onCaloriesReceived(calories);
                            } else {
                                System.err.println("Dokument użytkownika nie istnieje.");
                                callback.onCaloriesReceived(0); // Zwracamy 0 w przypadku braku dokumentu
                            }
                        } else {
                            Exception exception = task.getException();
                            if (exception != null) {
                                exception.printStackTrace();
                            }
                            callback.onCaloriesReceived(0); // Zwracamy 0 w przypadku błędu
                        }
                    });
        } else {
            System.err.println("Użytkownik nie jest zalogowany.");
            callback.onCaloriesReceived(0); // Zwracamy 0 w przypadku braku zalogowanego użytkownika
        }
    }

    public interface CaloriesCallback {
        void onCaloriesReceived(double calories);
    }

    public class User {
        private final String userId;
        private final String userEmail;
        private final double calories;

        public User(String userId, String userEmail, double calories) {
            this.userId = userId;
            this.userEmail = userEmail;
            this.calories = calories;
        }

        public String getUserId() {
            return userId;
        }

        public String getUserEmail() {
            return userEmail;
        }

        public double getCalories() {
            return calories;
        }
    }
}
