// SPDX-License-Identifier: UNLICENSED
pragma solidity ^0.8.0;


contract SimpleContract {
    string public greeting;

    constructor() {
        greeting = "Hello, World!";
    }

    function setGreeting(string memory _greeting) public {
        greeting = _greeting;
    }

    function getGreeting() public view returns (string memory) {
        return greeting;
    }
}