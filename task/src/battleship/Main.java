package battleship;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GamePlayerShip player1Ship = new GamePlayerShip();
        GamePlayerShip player2Ship = new GamePlayerShip();
        Game player1game = new Game();
        Game player2game = new Game();
        play(player1game,player2game, player1Ship, player2Ship);
    }

    private static void makeShip(Game game, String shipName, GamePlayerShip playerShip) {
        if (game.coordinateArray[0] == game.coordinateArray[2]) {
            int counter = 0;
            switch (shipName) {
                case "Aircraft Carrier":
                    for (int i = game.coordinateArray[1] - 1; i < game.coordinateArray[3]; i++) {
                        game.gameField[game.coordinateArray[0] - 1][i] = 'O';
                        playerShip.aircraftCarrier.shipSizeArray[counter][0] = game.coordinateArray[0];
                        playerShip.aircraftCarrier.shipSizeArray[counter][1] = i + 1;
                        counter++;
                    }
                    break;
                case "Battleship":
                    for (int i = game.coordinateArray[1] - 1; i < game.coordinateArray[3]; i++) {
                        game.gameField[game.coordinateArray[0] - 1][i] = 'O';
                        playerShip.battleship.shipSizeArray[counter][0] = game.coordinateArray[0];
                        playerShip.battleship.shipSizeArray[counter][1] = i + 1;
                        counter++;
                    }
                    break;
                case "Submarine":
                    for (int i = game.coordinateArray[1] - 1; i < game.coordinateArray[3]; i++) {
                        game.gameField[game.coordinateArray[0] - 1][i] = 'O';
                        playerShip.submarine.shipSizeArray[counter][0] = game.coordinateArray[0];
                        playerShip.submarine.shipSizeArray[counter][1] = i + 1;
                        counter++;
                    }
                    break;
                case "Cruiser":
                    for (int i = game.coordinateArray[1] - 1; i < game.coordinateArray[3]; i++) {
                        game.gameField[game.coordinateArray[0] - 1][i] = 'O';
                        playerShip.cruiser.shipSizeArray[counter][0] = game.coordinateArray[0];
                        playerShip.cruiser.shipSizeArray[counter][1] = i + 1;
                        counter++;
                    }
                    break;
                case "Destroyer":
                    for (int i = game.coordinateArray[1] - 1; i < game.coordinateArray[3]; i++) {
                        game.gameField[game.coordinateArray[0] - 1][i] = 'O';
                        playerShip.destroyer.shipSizeArray[counter][0] = game.coordinateArray[0];
                        playerShip.destroyer.shipSizeArray[counter][1] = i + 1;
                        counter++;
                    }
                    break;

            }
        } else if (game.coordinateArray[1] == game.coordinateArray[3]) {
            int counter = 0;
            switch (shipName) {
                case "Aircraft Carrier":
                    for (int i = game.coordinateArray[0] - 1; i < game.coordinateArray[2]; i++) {
                        game.gameField[i][game.coordinateArray[1] - 1] = 'O';
                        playerShip.aircraftCarrier.shipSizeArray[counter][1] = game.coordinateArray[1];
                        playerShip.aircraftCarrier.shipSizeArray[counter][0] = i + 1;
                        counter++;
                    }
                    break;
                case "Battleship":
                    for (int i = game.coordinateArray[0] - 1; i < game.coordinateArray[2]; i++) {
                        game.gameField[i][game.coordinateArray[1] - 1] = 'O';
                        playerShip.battleship.shipSizeArray[counter][1] = game.coordinateArray[1];
                        playerShip.battleship.shipSizeArray[counter][0] = i + 1;
                        counter++;
                    }
                    break;
                case "Submarine":
                    for (int i = game.coordinateArray[0] - 1; i < game.coordinateArray[2]; i++) {
                        game.gameField[i][game.coordinateArray[1] - 1] = 'O';
                        playerShip.submarine.shipSizeArray[counter][1] = game.coordinateArray[1];
                        playerShip.submarine.shipSizeArray[counter][0] = i + 1;
                        counter++;
                    }
                    break;
                case "Cruiser":
                    for (int i = game.coordinateArray[0] - 1; i < game.coordinateArray[2]; i++) {
                        game.gameField[i][game.coordinateArray[1] - 1] = 'O';
                        playerShip.cruiser.shipSizeArray[counter][1] = game.coordinateArray[1];
                        playerShip.cruiser.shipSizeArray[counter][0] = i + 1;
                        counter++;
                    }
                    break;
                case "Destroyer":
                    for (int i = game.coordinateArray[0] - 1; i < game.coordinateArray[2]; i++) {
                        game.gameField[i][game.coordinateArray[1] - 1] = 'O';
                        playerShip.destroyer.shipSizeArray[counter][1] = game.coordinateArray[1];
                        playerShip.destroyer.shipSizeArray[counter][0] = i + 1;
                        counter++;
                    }
                    break;
            }
        } else {
            System.out.println("Can't make ship!");
        }
    }

    private static void orderCoordinateArray(Game game) {
        int tempSmallerLetter;
        int tempLargerLetter;
        int tempSmallerNumber;
        int tempLargerNumber;
        if (game.coordinateArray[0] == game.coordinateArray[2]) {
            //kontrolli, esimene number on väiksem, kui teine number
            if (game.coordinateArray[3] < game.coordinateArray[1]) {
                tempSmallerNumber = game.coordinateArray[3];
                tempLargerNumber = game.coordinateArray[1];
                game.coordinateArray[1] = tempSmallerNumber;
                game.coordinateArray[3] = tempLargerNumber;

            }
        } else if (game.coordinateArray[1] == game.coordinateArray[3]) {
            //kontrolli kas esimene täht on väiksem, kui teine
            if (game.coordinateArray[2] < game.coordinateArray[0]) {
                tempSmallerLetter = game.coordinateArray[2];
                tempLargerLetter = game.coordinateArray[0];
                game.coordinateArray[0] = tempSmallerLetter;
                game.coordinateArray[2] = tempLargerLetter;
            }
        }
    }

    private static boolean makeArrayAndIsItOutOfBounds(Game game) {
        Scanner scanner = new Scanner(System.in);
        String firstCoordinate = scanner.next();
        String secondCoordinate = scanner.next();
        char firstCoordinateChar = firstCoordinate.charAt(0);
        char secondCoordinateChar = secondCoordinate.charAt(0);
        int firstCoordninateNumber = Integer.parseInt(String.valueOf(firstCoordinate.substring(1)));
        int secondCoordninateNumber = Integer.parseInt(String.valueOf(secondCoordinate.substring(1)));

        //kontrollin kas koordinaadid jäävad mänguväljaku piiridesse
        if (game.allowedLetters.indexOf(firstCoordinateChar) < 0 || game.allowedLetters.indexOf(secondCoordinateChar) < 0 || firstCoordninateNumber < 0 || secondCoordninateNumber < 0 || firstCoordninateNumber > 10 || secondCoordninateNumber > 10) {
            System.out.println("Error! Wrong ship location! Try again:");
            return true;
        } else {
            int firstCoordinateIndex = 0;
            int secondCoordinateIndex = 0;
            for (int i = 0; i < game.letterCoordinate.length; i++) {
                if (game.letterCoordinate[i] == firstCoordinateChar) {
                    firstCoordinateIndex = i + 1;
                }
                if (game.letterCoordinate[i] == secondCoordinateChar) {
                    secondCoordinateIndex = i + 1;
                }
            }


            game.coordinateArray[0] = firstCoordinateIndex;
            game.coordinateArray[1] = firstCoordninateNumber;
            game.coordinateArray[2] = secondCoordinateIndex;
            game.coordinateArray[3] = secondCoordninateNumber;
            if (game.coordinateArray[0] == game.coordinateArray[2] || game.coordinateArray[1] == game.coordinateArray[3]) {
                return false;
            } else {
                System.out.println("Error! Wrong ship location! Try again:");
                return true;
            }
        }
    }

    private static boolean isItRightLengthOfShip(Game game, String shipName, int shipLength) {
        //Kontrolli kas tähed on võrdsed
        //Kui tähed on võrdsed, siis numbrid peavad olema erinevad
        if (game.coordinateArray[0] == game.coordinateArray[2]) {
            //kontrolli, esimene number on väiksem, kui teine number
            if (game.coordinateArray[1] < game.coordinateArray[3]) {
                //TESTIB KAS LAEV ON ÕIGET SUURUST
                if (game.coordinateArray[3] - game.coordinateArray[1] + 1 == shipLength) {
                    //System.out.println("Right size of ship " + (game.coordinateArray[3] - game.coordinateArray[1]));
                    return false;
                } else {
                    System.out.println("Error! Wrong length of the " + shipName + "! Try again:");
                    return true;
                }
                // Kontrolli kas teine number on väiksem, kui esimene
            } else {
                if (game.coordinateArray[1] - game.coordinateArray[3] + 1 == shipLength) {
                    //System.out.println("Right size of ship " + (game.coordinateArray[1] - game.coordinateArray[3]));
                    return false;
                } else {
                    System.out.println("Error! Wrong length of the " + shipName + "! Try again:");
                    return true;
                }
            }
        } else if (game.coordinateArray[1] == game.coordinateArray[3]) {
            //kontrolli kas esimene täht on väiksem, kui teine
            if (game.coordinateArray[0] < game.coordinateArray[2]) {
                if (game.coordinateArray[2] - game.coordinateArray[0] + 1 == shipLength) {
                    //System.out.println("Right size of ship " + (game.coordinateArray[2] - game.coordinateArray[0]));
                    return false;
                } else {
                    System.out.println("Error! Wrong length of the " + shipName + "! Try again:");
                    return true;
                }
            } else {
                if (game.coordinateArray[0] - game.coordinateArray[2] + 1 == shipLength) {
                    //System.out.println("Right size of ship " + (game.coordinateArray[0] - game.coordinateArray[2]));
                    return false;
                } else {
                    System.out.println("Error! Wrong length of the " + shipName + "! Try again:");
                    return true;
                }
            }
        } else {
            System.out.println("Error! Wrong length of the " + shipName + "! Try again:");
            return true;
        }
    }

    private static boolean isItShipCoordinate(Game game) {
        int numOfWrongCoordinates = 0;
        boolean isItShip = true;

        // kui tähed on samad siis teeb rea peale laeva
        // järelikult peab kontrollima, kas iga numbri koha peal on laeva
        // SAMA REA PEAL ON LAEV EHK VASAKULT PAREMALE
        if (game.coordinateArray[0] == game.coordinateArray[2]) {
            for (int i = game.coordinateArray[1] - 1; i < game.coordinateArray[3]; i++) {
                if (numOfWrongCoordinates == 0 && game.gameField[game.coordinateArray[0] - 1][i] != 'O') {
                    //System.out.println("i: " + (i) + "      game.coordinateArray[0]: " + (game.coordinateArray[0] - 1));
                    isItShip = false;
                } else {
                    //System.out.println("i: " + (i) + "      game.coordinateArray[1] - 1: " + (game.coordinateArray[0] - 1));
                    System.out.println("Error! There are already ship. Try again:");
                    numOfWrongCoordinates++;
                    break;
                }
            }

            //kui numbrid on samad
            //SAMA VEERU PEAL EHK ÜLEVALT ALLA
        } else {
            for (int i = game.coordinateArray[0] - 1; i < game.coordinateArray[2]; i++) {
                if (numOfWrongCoordinates == 0 && game.gameField[i][game.coordinateArray[1] - 1] != 'O') {
                    //System.out.println("i: " + (i) + "      game.coordinateArray[1] - 1: " + (game.coordinateArray[1] - 1));
                    isItShip = false;
                } else {
                    //System.out.println("i: " + (i) + "     game.coordinateArray[1] - 1: " + (game.coordinateArray[1] - 1));
                    System.out.println("Error! There are already ship. Try again:");
                    numOfWrongCoordinates++;
                    break;
                }
            }
        }

        return isItShip;
    }

    private static boolean isItNearCoordinate(Game game) {
        int numOfNearCoordinates = 0;
        boolean notNearCoordinate = true;

        if (game.coordinateArray[0] == game.coordinateArray[2]) {
            for (int i = game.coordinateArray[1] - 1; i < game.coordinateArray[3]; i++) {
                //Ülemine vasak nurk
                if (numOfNearCoordinates == 0 && game.coordinateArray[0] == 1 && game.coordinateArray[1] == 1) {
                    if (game.gameField[game.coordinateArray[0] - 1][game.coordinateArray[3]] != 'O' &&
                            game.gameField[game.coordinateArray[0]][game.coordinateArray[3]] != 'O' &&
                            game.gameField[game.coordinateArray[0]][i] != 'O') {

                        notNearCoordinate = false;
                    } else {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        numOfNearCoordinates++;
                    }
                    //ülemine parem nurk
                } else if (numOfNearCoordinates == 0 && game.coordinateArray[0] == 1 && game.coordinateArray[3] == 10) {
                    if (game.gameField[game.coordinateArray[0] - 1][game.coordinateArray[1] - 2] != 'O' &&
                            game.gameField[game.coordinateArray[0]][game.coordinateArray[1] - 2] != 'O' &&
                            game.gameField[game.coordinateArray[0]][i] != 'O') {

                        notNearCoordinate = false;
                    } else {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        numOfNearCoordinates++;
                    }
                } else if (numOfNearCoordinates == 0 && game.coordinateArray[0] == 10 && game.coordinateArray[1] == 1) {
                    if (game.gameField[game.coordinateArray[0] - 1][game.coordinateArray[3]] != 'O' &&
                            game.gameField[game.coordinateArray[0] - 2][game.coordinateArray[3]] != 'O' &&
                            game.gameField[game.coordinateArray[0] - 2][i] != 'O') {

                        notNearCoordinate = false;
                    } else {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        numOfNearCoordinates++;
                    }
                }
                //alumine parem nurk
                else if (numOfNearCoordinates == 0 && game.coordinateArray[0] == 10 && game.coordinateArray[3] == 10) {
                    if (game.gameField[game.coordinateArray[0] - 1][game.coordinateArray[1] - 2] != 'O' &&
                            game.gameField[game.coordinateArray[0] - 2][game.coordinateArray[1] - 2] != 'O' &&
                            game.gameField[game.coordinateArray[0] - 2][i] != 'O') {

                        notNearCoordinate = false;
                    } else {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        numOfNearCoordinates++;
                    }
                    //Kui on kusagil keskel vasaku külje küljes
                } else if (numOfNearCoordinates == 0 && game.coordinateArray[1] == 1) {
                    if (game.gameField[game.coordinateArray[0] - 1][game.coordinateArray[3]] != 'O' &&
                            game.gameField[game.coordinateArray[0] - 2][game.coordinateArray[3]] != 'O' &&
                            game.gameField[game.coordinateArray[0]][game.coordinateArray[3]] != 'O' &&
                            game.gameField[game.coordinateArray[0] - 2][i] != 'O' &&
                            game.gameField[game.coordinateArray[0]][i] != 'O') {

                        notNearCoordinate = false;
                    } else {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        numOfNearCoordinates++;
                    }
                    //kui on kusagil parema külje küljes
                } else if (numOfNearCoordinates == 0 && game.coordinateArray[3] == 10) {
                    if (game.gameField[game.coordinateArray[0] - 1][game.coordinateArray[1] - 2] != 'O' &&
                            game.gameField[game.coordinateArray[0] - 2][game.coordinateArray[1] - 2] != 'O' &&
                            game.gameField[game.coordinateArray[0]][game.coordinateArray[1] - 2] != 'O' &&
                            game.gameField[game.coordinateArray[0] - 2][i] != 'O' &&
                            game.gameField[game.coordinateArray[0] + 1][i] != 'O') {

                        notNearCoordinate = false;
                    } else {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        numOfNearCoordinates++;
                    }
                    //alumise ääre peal, kui ei ole nurgas
                } else if (numOfNearCoordinates == 0 && game.coordinateArray[0] == 10) {
                    if (game.gameField[game.coordinateArray[0] - 1][game.coordinateArray[1] - 2] != 'O' &&
                            game.gameField[game.coordinateArray[0] - 1][game.coordinateArray[3]] != 'O' &&
                            game.gameField[game.coordinateArray[0] - 2][game.coordinateArray[3]] != 'O' &&
                            game.gameField[game.coordinateArray[0] - 2][game.coordinateArray[1] - 2] != 'O' &&
                            game.gameField[game.coordinateArray[0] - 2][i] != 'O') {

                        notNearCoordinate = false;
                    } else {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        numOfNearCoordinates++;
                    }
                    //kusagil üleval ääres aga mitte nurgas
                } else if (numOfNearCoordinates == 0 && game.coordinateArray[0] == 1) {
                    if (game.gameField[game.coordinateArray[0] - 1][game.coordinateArray[1] - 2] != 'O' &&
                            game.gameField[game.coordinateArray[0] - 1][game.coordinateArray[3]] != 'O' &&
                            game.gameField[game.coordinateArray[0]][game.coordinateArray[1] - 2] != 'O' &&
                            game.gameField[game.coordinateArray[0]][game.coordinateArray[3]] != 'O' &&
                            game.gameField[game.coordinateArray[0]][i] != 'O') {

                        notNearCoordinate = false;
                    } else {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        numOfNearCoordinates++;
                    }
                    //kui on keskel ja ei ole ääres
                } else if (numOfNearCoordinates == 0) {
                    if (game.gameField[game.coordinateArray[0] - 1][game.coordinateArray[1] - 2] != 'O' &&
                            game.gameField[game.coordinateArray[0] - 1][game.coordinateArray[3]] != 'O' &&
                            game.gameField[game.coordinateArray[0] - 2][game.coordinateArray[1] - 2] != 'O' &&
                            game.gameField[game.coordinateArray[0] - 2][game.coordinateArray[3]] != 'O' &&
                            game.gameField[game.coordinateArray[0]][game.coordinateArray[1] - 2] != 'O' &&
                            game.gameField[game.coordinateArray[0]][game.coordinateArray[3]] != 'O' &&
                            game.gameField[game.coordinateArray[0] - 2][i] != 'O' &&
                            game.gameField[game.coordinateArray[0]][i] != 'O') {

                        notNearCoordinate = false;
                    } else {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        numOfNearCoordinates++;
                    }
                }
            }

            //kui numbrid on samad
            //SAMA VEERU PEAL EHK ÜLEVALT ALLA
        } else {
            for (int i = game.coordinateArray[0] - 1; i < game.coordinateArray[2]; i++) {
                //Ülemine vasak nurk
                if (numOfNearCoordinates == 0 && game.coordinateArray[0] == 1 && game.coordinateArray[1] == 1) {
                    if (game.gameField[game.coordinateArray[2]][game.coordinateArray[1] - 1] != 'O' &&
                            game.gameField[game.coordinateArray[2]][game.coordinateArray[1]] != 'O' &&
                            game.gameField[i][game.coordinateArray[1]] != 'O') {

                        notNearCoordinate = false;
                    } else {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        numOfNearCoordinates++;
                    }
                    //ülemine parem nurk
                } else if (numOfNearCoordinates == 0 && game.coordinateArray[0] == 1 && game.coordinateArray[1] == 10) {
                    if (game.gameField[game.coordinateArray[2]][game.coordinateArray[1] - 1] != 'O' &&
                            game.gameField[game.coordinateArray[2]][game.coordinateArray[1] - 2] != 'O' &&
                            game.gameField[i][game.coordinateArray[1] - 2] != 'O') {

                        notNearCoordinate = false;
                    } else {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        numOfNearCoordinates++;
                    }
                    //vasak alumine nurk
                } else if (numOfNearCoordinates == 0 && game.coordinateArray[2] == 10 && game.coordinateArray[1] == 1) {
                    if (game.gameField[game.coordinateArray[0] - 2][game.coordinateArray[1] - 1] != 'O' &&
                            game.gameField[game.coordinateArray[0] - 2][game.coordinateArray[1]] != 'O' &&
                            game.gameField[i][game.coordinateArray[1]] != 'O') {

                        notNearCoordinate = false;
                    } else {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        numOfNearCoordinates++;
                    }
                }
                //alumine parem nurk
                else if (numOfNearCoordinates == 0 && game.coordinateArray[2] == 10 && game.coordinateArray[3] == 10) {
                    if (game.gameField[game.coordinateArray[0] - 2][game.coordinateArray[1] - 1] != 'O' &&
                            game.gameField[game.coordinateArray[0] - 2][game.coordinateArray[1] - 2] != 'O' &&
                            game.gameField[i][game.coordinateArray[1] - 2] != 'O') {

                        notNearCoordinate = false;
                    } else {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        numOfNearCoordinates++;
                    }
                    //Kui on kusagil keskel vasaku külje küljes
                } else if (numOfNearCoordinates == 0 && game.coordinateArray[1] == 1 && game.coordinateArray[3] == 1) {
                    if (game.gameField[game.coordinateArray[0] - 2][game.coordinateArray[1] - 1] != 'O' &&
                            game.gameField[game.coordinateArray[2]][game.coordinateArray[1] - 1] != 'O' &&
                            game.gameField[game.coordinateArray[0] - 2][game.coordinateArray[1]] != 'O' &&
                            game.gameField[game.coordinateArray[2]][game.coordinateArray[1]] != 'O' &&
                            game.gameField[i][game.coordinateArray[1]] != 'O') {

                        notNearCoordinate = false;
                    } else {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        numOfNearCoordinates++;
                    }
                    //kui on kusagil parema külje küljes
                } else if (numOfNearCoordinates == 0 && game.coordinateArray[1] == 10 && game.coordinateArray[3] == 10) {
                    if (game.gameField[game.coordinateArray[0] - 2][game.coordinateArray[1] - 1] != 'O' &&
                            game.gameField[game.coordinateArray[2]][game.coordinateArray[1] - 1] != 'O' &&
                            game.gameField[game.coordinateArray[0] - 2][game.coordinateArray[1] - 2] != 'O' &&
                            game.gameField[game.coordinateArray[2]][game.coordinateArray[1] - 2] != 'O' &&
                            game.gameField[i][game.coordinateArray[1] - 2] != 'O') {

                        notNearCoordinate = false;
                    } else {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        numOfNearCoordinates++;
                    }
                    //alumise ääre peal, kui ei ole nurgas
                } else if (numOfNearCoordinates == 0 && game.coordinateArray[2] == 10) {
                    if (game.gameField[game.coordinateArray[0] - 2][game.coordinateArray[1] - 1] != 'O' &&
                            game.gameField[game.coordinateArray[0] - 2][game.coordinateArray[1] - 2] != 'O' &&
                            game.gameField[game.coordinateArray[0] - 2][game.coordinateArray[1]] != 'O' &&
                            game.gameField[i][game.coordinateArray[1] - 2] != 'O' &&
                            game.gameField[i][game.coordinateArray[1]] != 'O') {

                        notNearCoordinate = false;
                    } else {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        numOfNearCoordinates++;
                    }
                    //kusagil üleval ääres aga mitte nurgas
                } else if (numOfNearCoordinates == 0 && game.coordinateArray[0] == 1) {
                    if (game.gameField[game.coordinateArray[2]][game.coordinateArray[1] - 1] != 'O' &&
                            game.gameField[game.coordinateArray[2]][game.coordinateArray[1] - 2] != 'O' &&
                            game.gameField[game.coordinateArray[2]][game.coordinateArray[1]] != 'O' &&
                            game.gameField[i][game.coordinateArray[1] - 2] != 'O' &&
                            game.gameField[i][game.coordinateArray[1]] != 'O') {

                        notNearCoordinate = false;
                    } else {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        numOfNearCoordinates++;
                    }
                    //kui on keskel ja ei ole ääres
                } else if (numOfNearCoordinates == 0) {
                    if (game.gameField[game.coordinateArray[2]][game.coordinateArray[1] - 1] != 'O' &&
                            game.gameField[game.coordinateArray[2]][game.coordinateArray[1] - 2] != 'O' &&
                            game.gameField[game.coordinateArray[2]][game.coordinateArray[1]] != 'O' &&
                            game.gameField[game.coordinateArray[0] - 2][game.coordinateArray[1] - 1] != 'O' &&
                            game.gameField[game.coordinateArray[0] - 2][game.coordinateArray[1] - 2] != 'O' &&
                            game.gameField[game.coordinateArray[0] - 2][game.coordinateArray[1]] != 'O' &&
                            game.gameField[i][game.coordinateArray[1] - 2] != 'O' &&
                            game.gameField[i][game.coordinateArray[1]] != 'O') {

                        notNearCoordinate = false;
                    } else {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                        numOfNearCoordinates++;
                    }
                }
            }
        }
        return notNearCoordinate;
    }

    private static void printGameFieldWithShips(Game game) {
        System.out.print(" ");
        for (int i = 1; i <= 10; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < game.gameField.length; i++) {
            System.out.print(game.letterCoordinate[i] + "");
            for (int j = 0; j < game.gameField[i].length; j++) {
                System.out.print(" " + game.gameField[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void printGameFieldWithoutShips(Game game) {
        System.out.print(" ");
        for (int i = 1; i <= 10; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < game.gameField.length; i++) {
            System.out.print(game.letterCoordinate[i] + "");
            for (int j = 0; j < game.gameField[i].length; j++) {
                if (game.gameField[i][j] == 'X') {
                    System.out.print(" " + 'X');
                } else if (game.gameField[i][j] == 'M') {
                    System.out.print(" " + 'M');
                } else {
                    System.out.print(" " + '~');
                }
            }
            System.out.println();
        }
    }

    private static void printTwoGameFields(Game opponent, Game yourself){
        printGameFieldWithoutShips(opponent);
        System.out.println("---------------------");
        printGameFieldWithShips(yourself);
    }

    private static void makeInitialGameField(Game game) {
        System.out.print(" ");
        for (int i = 1; i <= 10; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < game.gameField.length; i++) {
            System.out.print(game.letterCoordinate[i] + " ");
            for (int j = 0; j < game.gameField[i].length; j++) {
                game.gameField[i][j] = '~';
                System.out.print(" " + game.gameField[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean gameStarts(Game game, GamePlayerShip playerShip ) {
        Scanner scanner = new Scanner(System.in);
        boolean aircraftCarrierSink = true;
        boolean battleshipSink = true;
        boolean submarineSink = true;
        boolean cruiserSink = true;
        boolean destroyerSink = true;


        String firstCoordinate = scanner.next();
        char firstCoordinateChar = firstCoordinate.charAt(0);
        int firstCoordninateNumber = Integer.parseInt(String.valueOf(firstCoordinate.substring(1)));
        //kontrollin kas koordinaadid jäävad mänguväljaku piiridesse
        if (game.allowedLetters.indexOf(firstCoordinateChar) < 0 || firstCoordninateNumber < 0 || firstCoordninateNumber > 10) {
            System.out.println("Error! You entered the wrong coordinates! Try again:");
            return true;
        } else {
            int firstCoordinateIndex = 0;
            for (int i = 0; i < game.letterCoordinate.length; i++) {
                if (game.letterCoordinate[i] == firstCoordinateChar) {
                    firstCoordinateIndex = i + 1;
                }
            }

            game.bombingArray[0] = firstCoordinateIndex;
            game.bombingArray[1] = firstCoordninateNumber;

            //Siin kogu kontrolli mõte on anda game.gameField array väärtuseid
            if (game.gameField[game.bombingArray[0] - 1][game.bombingArray[1] - 1] == 'O') {
                game.gameField[game.bombingArray[0] - 1][game.bombingArray[1] - 1] = 'X';

                playerShip.aircraftCarrier.controlTheHit(game.bombingArray[0], game.bombingArray[1]);
                playerShip.battleship.controlTheHit(game.bombingArray[0], game.bombingArray[1]);
                playerShip.submarine.controlTheHit(game.bombingArray[0], game.bombingArray[1]);
                playerShip.cruiser.controlTheHit(game.bombingArray[0], game.bombingArray[1]);
                playerShip.destroyer.controlTheHit(game.bombingArray[0], game.bombingArray[1]);


                aircraftCarrierSink = playerShip.aircraftCarrier.isShipDrowned();
                battleshipSink = playerShip.battleship.isShipDrowned();
                submarineSink = playerShip.submarine.isShipDrowned();
                cruiserSink = playerShip.cruiser.isShipDrowned();
                destroyerSink = playerShip.destroyer.isShipDrowned();

            } else if (game.gameField[game.bombingArray[0] - 1][game.bombingArray[1] - 1] == '~') {
                game.gameField[game.bombingArray[0] - 1][game.bombingArray[1] - 1] = 'M';
                System.out.println("You missed!");
            }
            return aircraftCarrierSink || battleshipSink || submarineSink || cruiserSink || destroyerSink;

        }
    }

    private static void makeAllShips(Game game, GamePlayerShip playerShip){
        Scanner scanner = new Scanner(System.in);
        makeInitialGameField(game);

        for (int i = 0; i < game.shipNamesArray.length; i++) {
            boolean rightShipSize = true;
            boolean outOfBounds = true;
            boolean notShipCoordinate = true;
            boolean notNearCoordinate = true;
            System.out.println("Enter the coordinates of the " + (game.shipNamesArray[i]) + " (" + (game.shipSizeArray[i]) + " cells):");
            while (outOfBounds || rightShipSize || notShipCoordinate || notNearCoordinate) {
                outOfBounds = makeArrayAndIsItOutOfBounds(game);
                if (!outOfBounds) {
                    orderCoordinateArray(game);
                    rightShipSize = isItRightLengthOfShip(game, game.shipNamesArray[i], game.shipSizeArray[i]);
                    notShipCoordinate = isItShipCoordinate(game);
                    if (!notShipCoordinate) {
                        notNearCoordinate = isItNearCoordinate(game);
                    }
                }
            }
            makeShip(game, game.shipNamesArray[i], playerShip);
            printGameFieldWithShips(game);

        }
    }

    private static void nextPlayer() {
        Scanner scanner = new Scanner(System.in);
        boolean hasEnterBeenPressed = false;
        while (!hasEnterBeenPressed) {
            System.out.println();
            System.out.println("Press Enter and pass the move to another player");
            System.out.println("...");
            String userInput = scanner.nextLine();
            if (userInput.isEmpty()){
                hasEnterBeenPressed = true;
            }
        }
    }

    private static void play(Game player1game, Game player2game, GamePlayerShip player1Ship, GamePlayerShip player2Ship){
        boolean stillSomeShipsPlayer1 = true;
        boolean stillSomeShipsPlayer2 = true;

        boolean player1turn = true;

        System.out.println("Player 1, place your ships on the game field");
        makeAllShips(player1game, player1Ship);
        nextPlayer();
        System.out.println("Player 2, place your ships to the game field");
        makeAllShips(player2game, player2Ship);

        printGameFieldWithShips(player1game);
        printGameFieldWithShips(player2game);



        nextPlayer();
        while (stillSomeShipsPlayer1 || stillSomeShipsPlayer2) {
            if(player1turn){
                printTwoGameFields(player2game, player1game);
                System.out.println("Player 1, it's your turn:");
                stillSomeShipsPlayer2 = gameStarts(player2game, player2Ship);

                nextPlayer();

                player1turn = false;
            } else {
                printTwoGameFields(player1game, player2game);
                System.out.println("Player 2, it's your turn:");
                stillSomeShipsPlayer1 = gameStarts(player1game, player1Ship);

                nextPlayer();
                player1turn = true;
            }

        }
        if(!stillSomeShipsPlayer1){
            System.out.println("Player 2 You sank the last ship. You won. Congratulations!");
        }else if (!stillSomeShipsPlayer2) {
            System.out.println("Player 1 You sank the last ship. You won. Congratulations!");
        }
    }

}

class Ship {
    private String name;
    private int counter = 0;
    private int shipSize;

    private int allShipsSize = 0;
    int[][] shipSizeArray;

    public Ship(String name, int shipSize, int counter) {
        this.name = name;
        this.shipSize = shipSize;
        this.shipSizeArray = new int[shipSize][2];
        this.counter = counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getShipSize() {
        return shipSize;
    }

    public void setShipSize(int shipSize) {
        this.shipSize = shipSize;
    }

    public boolean isShipDrowned() {
        this.allShipsSize++;
        if (allShipsSize <= 17) {

        }
        System.out.println(this.allShipsSize);
        if (this.counter == this.shipSize && allShipsSize < 16) {
            System.out.println("You sank a ship! Specify a new target:");
            this.counter++;
            return false;
        } else if (this.counter == this.shipSize && allShipsSize > 16 ){
            System.out.println("You sank the last ship. You won. Congratulations!");
            this.counter++;
            return false;
        }else if (this.counter > this.shipSize) {
            return false;
        }
        return true;
    }

    public void controlTheHit(int letterCoordinate, int numberCoordinate) {
        for (int i = 0; i < shipSizeArray.length; i++) {
            if (shipSizeArray[i][0] == letterCoordinate && shipSizeArray[i][1] == numberCoordinate) {
                this.counter++;
                if (this.counter < shipSize) {
                    System.out.println("You hit a ship!");
                }
            }
        }
    }
}

class GamePlayerShip {
    Ship aircraftCarrier = new Ship("Aircraft Carrier", 5, 0);
    Ship battleship = new Ship("Battleship", 4, 0);
    Ship submarine = new Ship("Submarine", 3, 0);
    Ship cruiser = new Ship("Cruiser", 3, 0);
    Ship destroyer = new Ship("Destroyer", 2, 0);
}

class Game {
    //Ideaalis võetakse siia väärtused letterCoordinate.length-st
    char[][] gameField = new char[10][10];
    char[] letterCoordinate = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    //ideaalis võetakse siia väärtused letterCoordinatest
    String allowedLetters = "ABCDEFGHIJ";
    int[] coordinateArray = new int[4];
    int[] bombingArray = new int[2];
    //Ideaalis võetakse siia väärtused classist GamePlayerShips name alt
    String[] shipNamesArray = new String[]{"Aircraft Carrier", "Battleship", "Submarine", "Cruiser", "Destroyer"};
    //Ideaalis võetakse siia väärtused classist GamePlayerShips shipsize alt
    int[] shipSizeArray = new int[]{5, 4, 3, 3, 2};
}
