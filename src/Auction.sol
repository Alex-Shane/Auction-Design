// SPDX-License-Identifier: GPL-3.0
import "@openzeppelin/contracts/token/ERC721/ERC721.sol";
import "@openzeppelin/contracts/token/ERC721/extensions/ERC721Enumerable.sol";
pragma solidity >=0.8.9;

contract Auction{
    address payable public seller;
    address public highestBidder;
    IERC721 public nft;
    uint public nftID;
    uint public highestBid = 0;
    uint public startingPrice;

    event Win(address winner, uint amt);
    
    modifier sufficientBalance(uint balance) {
        require(msg.sender.balance > balance, "User needs to have sufficient balance to bid for item");
        _;
    }
    
    constructor (){
        seller = payable(msg.sender);
    }
    
    function setNFT(address _nft, uint _nftID, uint _startingPrice) public {
        require(_startingPrice > 0, "Your price cannot be negative or 0");
        nft = IERC721(_nft);
        nftID = _nftID;
        startingPrice = _startingPrice;
    }
    
    function makeBid (uint amt, string memory messageToSeller) public sufficientBalance(amt) returns (string memory){
        require(amt > 0, "Your bid cannot be negative or 0");
        if (amt>highestBid){
            highestBid = amt;
            highestBidder = msg.sender;
        }
        return (messageToSeller);
    }

    function winAuction () public payable sufficientBalance(highestBid){
        if (highestBidder != address(0)) {
        nft.safeTransferFrom(address(this), highestBidder, nftID);
        emit Win(highestBidder, highestBid);
        } else {
            nft.safeTransferFrom(address(this), seller, nftID);
        }
    }
    
}