// SPDX-License-Identifier: GPL-3.0
pragma solidity >=0.8.9;

contract User{
    string private password;
    address public userAddress;
    
    constructor (address _userAddress){
        userAddress = _userAddress;
    }
    
    function register (string memory _password) public{
        password = _password;
    }
    
    function checkBalance (address _userAddress) public view returns (uint){
        return (_userAddress.balance);
    }
    
}