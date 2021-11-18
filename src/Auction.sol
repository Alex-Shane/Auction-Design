// SPDX-License-Identifier: GPL-3.0
import "@openzeppelin/contracts/token/ERC721/ERC721.sol";
import "@openzeppelin/contracts/token/ERC721/extensions/ERC721Enumerable.sol";
pragma solidity >=0.8.9;

contract Auction{
    address payable public seller;
    address public highestBidder;
    ERC721 public nft;
    uint public nftID;
    uint public highestBid = 0;
    uint public startingPrice;

    event Win(address winner, uint amt);
    
    modifier highEnoughBid(uint bidPrice)
    {
        require(bidPrice>highestBid, "Bid is lower than highest bid! Bid again!");
        _;
    }
    
    constructor (){
        seller = payable(msg.sender);
    }
    
    function setNFT(address _nft, uint _nftID, uint _startingPrice) external {
        require(_startingPrice > 0, "Your price cannot be negative or 0");
        nft = ERC721(_nft);
        nftID = _nftID;
        startingPrice = _startingPrice;
    }
    
    function makeBid (uint amt, string memory messageToSeller) public highEnoughBid(amt) returns (string memory){
        require(amt > 0, "Your bid cannot be negative or 0");
        if (amt>highestBid){
            highestBid = amt;
            highestBidder = msg.sender;
        }
        return (messageToSeller);
    }

    function winAuction () external payable {
        if (highestBidder != address(0)) {
            nft.safeTransferFrom(address(this), highestBidder, nftID);
        } 
        emit Win(highestBidder, highestBid);
    }
    
}