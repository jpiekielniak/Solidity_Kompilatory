// SimpleStorage.sol
pragma solidity ^0.8.0;

contract SimpleStorage {
    uint256 private storedData;

    constructor(uint256 x) {
        storedData = x;
    }

}
