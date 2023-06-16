# Pharmacy Management System

The Pharmacy Management System is a desktop application built using JavaFX and MySQL Database. It provides a comprehensive solution for managing various aspects of a pharmacy, including inventory management, medicine orders, sales, refunds, and generating reports.

## Features

- **Inventory Management:** Allows users to track and manage the quantity of medicines in the pharmacy. Users can add new medicines, update quantities, and receive new stock from suppliers.
- **Medicine Ordering:** Provides functionality to order medicines from suppliers. Users can generate purchase orders, track delivery status, and update stock upon receipt.
- **Sales Management:** Enables users to process sales transactions, calculate prices, and update inventory accordingly. It includes features like adding items to the cart, applying discounts, and generating sales invoices.
- **Refunds:** Allows users to process refunds for returned or damaged medicines. It tracks refunded quantities and updates the inventory accordingly.
- **Reporting:** Generates various reports, such as inventory reports, sales reports, profit/loss statements, and supplier performance reports. These reports provide insights into the pharmacy's operations and financial status.

## Prerequisites

- Java Development Kit (JDK) installed on your machine
- MySQL Database Server installed and running

## Installation

1. Clone the Repository: Clone this repository to your local machine or download the source code as a ZIP file and extract it.

2. Set Up the Database: Create a MySQL database for the Pharmacy Management System. Execute the provided SQL scripts (`schema.sql` and `data.sql`) to create the necessary tables and seed sample data.

3. Configure Database Connection: Open the project in your preferred Integrated Development Environment (IDE) and locate the database connection configuration file. Update the database connection details (such as URL, username, and password) to match your MySQL database configuration.

4. Build and Run the Application: Build the project using your IDE's build tools and run the application. Ensure all dependencies are properly resolved.

## Usage

1. Login: Upon launching the application, users will be prompted to log in with their credentials.

2. Dashboard: After successful login, users will be directed to the dashboard, which provides an overview of key statistics and features of the Pharmacy Management System.

3. Inventory Management: Users can navigate to the inventory management section to view, add, update, and delete medicines. The quantity of medicines can be adjusted, and new medicines can be added to the inventory.

4. Medicine Ordering: Users can access the medicine ordering section to generate purchase orders, track delivery status, and update the stock upon receipt from suppliers.

5. Sales Management: The sales management section allows users to process sales transactions, add items to the cart, apply discounts, and generate sales invoices. The inventory is automatically updated after each successful sale.

6. Refunds: Users can handle refunds for returned or damaged medicines. The system tracks refunded quantities and updates the inventory accordingly.

7. Reporting: Various reports can be generated, providing insights into inventory status, sales, profit/loss statements, and supplier performance.

## Contributing

Contributions to the Pharmacy Management System project are welcome! If you have any improvements, bug fixes, or new features, please feel free to submit a pull request. 

## License

This project is licensed under the [MIT License](LICENSE).

