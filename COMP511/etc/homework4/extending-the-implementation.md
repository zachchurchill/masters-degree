# Extending the Implementation
Consider how you might combine both substitution and transposition cyphers into a composite algorithm that does both to plain text.

Describe how that would be accomplished with the Strategy pattern:
> If I were to utilize the strategy pattern to perform this operation,
then I would likely need to take the strategies in the intended order during initialization.
That way I could implement the necessary encryption/decryption pipeline in the methods of the class I'm using for the strategy pattern.

Describe how that would be accomplished with the Template Method pattern:
> If I were to utilize the template method pattern to perform this operation,
then I may need to specify an additional abstract method to incorporate the output from one child class with its own encrypted/decrypted data.

Which would be easier to implement and why?
> I believe the strategy pattern would be easier to implement because specifying the order of ciphers at initialization
and then leaving the details of how and in which order these ciphers are applied to encryption/decryption is better left
to the implementation class instead of the cipher classes.
