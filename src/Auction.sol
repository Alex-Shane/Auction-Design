// SPDX-License-Identifier: GPL-3.0
import "@openzeppelin/contracts/token/ERC721/ERC721.sol";
import "@openzeppelin/contracts/token/ERC721/extensions/ERC721Enumerable.sol";
pragma solidity >=0.8.9;

contract Auction{
    address payable public seller;
    address public winner;
    IERC721 public nft;
    uint public nftID;
    uint public highestBid = 0;
    uint public startingPrice;
    uint256 public incentive;
    
    event Win(address winner, uint amt);
    
    constructor (){
        seller = payable(msg.sender);
    }
    
    function setNFT(address _nft, uint _nftID, uint _startingPrice) public {
        nft = IERC721(_nft);
        nftID = _nftID;
        startingPrice = _startingPrice;
    }
    
    function makeBid (uint amt, string memory messageToSeller) public returns (string memory){
        if (amt>highestBid){
            highestBid = amt;
        }
        return (messageToSeller);
    }

    function winAuction () external payable {
        require(msg.value >= startingPrice, "ETH < price");
        winner = msg.sender;
        nft.safeTransferFrom(seller, msg.sender, nftID);
        seller.transfer(msg.value);
        emit Win(msg.sender, msg.value);
        
        incentive = (msg.value * 98)/100;
        payable(winner).transfer(incentive);
    }
    
}