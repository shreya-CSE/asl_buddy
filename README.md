# English to ASL Translator App

## Project Overview

This project aims to create a mobile app that utilizes voice recognition to translate English speech into American Sign Language (ASL) symbols. The app includes features such as user authentication, a translator, and a vocabulary builder to enhance ASL learning.

## Features

### 1. User Authentication

- **Sign-up using Firebase:** Allows users to create an account using Firebase authentication.
- **Login using Firebase:** Two options for login: system login or Google sign-in.
  - System login with username and password.
  - Google sign-in with Google email and password.
- **Password Recovery:**
  - Entering an invalid user ID prevents login.
  - Forgot user ID option sends an email for password recovery when a valid user ID is entered.
  - Entering an invalid user ID and selecting the forgot user ID option will not prompt the validator to send an email with instructions for password recovery.

### 2. Account Management

- **Create Account:** Users can create a new account by providing personal information.
- **Edit Personal Information:** Allows users to edit first name, last name, email address, and phone number. Confirm or cancel changes.
- **Close Account:** Requests confirmation before deleting the account.

### 3. Translator

- **Text Input:**
  - Allows users to type in an English word using the device's keyboard.
  - Searches for the corresponding ASL word in the built-in vocabulary.
  - Displays ASL image if the word is found.
  - Shows an error message if the word is not found.
- **Voice Input:**
  - Converts microphone input to text.
  - Displays ASL symbols for words found in the vocabulary.
  - Notifies the user about words not found in the vocabulary.

### 4. Vocabulary Builder

- **Learning by Choosing Word for ASL Image:**
  - Updates and displays progress tracker for correct word selection.
  - Displays progress tracker without changes for incorrect word selection.
- **Learning by Picking ASL Image for Word:**
  - Updates and displays progress tracker for correct ASL image selection.
  - Displays progress tracker without changes for incorrect ASL image selection.
- **Reminder for Unauthenticated Users:**
  - Notifies users if they forget to log in to the app when using the vocabulary builder.

## Requirements

- Firebase account for authentication.
- Internet connection for voice recognition features.

## Installation

1. Clone the repository.
2. Install dependencies using `npm install`.
3. Set up Firebase authentication.

## Usage

1. Run the app on your preferred platform (iOS/Android).
2. Sign up or log in to access the translator and vocabulary builder features.

## License

This project is licensed under the [MIT License](LICENSE).
